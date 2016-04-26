package com.infinityCableService.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinityCableService.dao.ChannelDao;
import com.infinityCableService.dao.Package_ChannelDao;
import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.dao.UserDao;
import com.infinityCableService.model.Packages;

/**
 * Servlet implementation class PackagesControllerServlet
 */

public class PackagesControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackagesControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action == null) {
			url = "/adminHomePage.jsp";
		} else {
			switch (action) {
				case "addNewPackage":
					//query channel list from channel table.
					List<String> channelListfromDb = ChannelDao.getAllChannels();
					//set the channel list in request
					request.setAttribute("channelList", channelListfromDb);
					//redirect to addnewPackage page 
					url = "/addPackage.jsp";
					break;
				
				case "addPackage":
					//get package details 
					String pckgName = request.getParameter("packageName");
					double pckgPrice  = Double.parseDouble(request.getParameter("price"));
					String pckgDesc  = request.getParameter("pckgDesc");
					String[] selectedChannelList = request.getParameterValues("channelSelection");
					//insert the new package in packages table.
					int newPckgId = PackagesDao.createNewPckg(pckgName, pckgPrice, pckgDesc);
					if(newPckgId != 0){
						//get channel ids for the channels selected
						List<Integer> chnlIds = ChannelDao.getChannelIds(selectedChannelList);
						int noOfRowsInserted = Package_ChannelDao.createPckgChnl(newPckgId, chnlIds);
						System.out.println("No.of channels selected: " +selectedChannelList.length);
						System.out.println("No.of channels inserted in Package_Channel table: " +noOfRowsInserted);
						url = "/adminHomePage.jsp";
					}else {
						System.out.println("New Package creation failed");
						request.setAttribute("msg", "***New Package Creation failed***");
						url = "/addPackage.jsp";
					}
								
					break;
				
				case "updatePackage" :
					 List<String> packgList = PackagesDao.getPckgNames();
					 request.setAttribute("packgList", packgList);
					 url = "/updatePackage.jsp";
					 break;
				
				case "deletePackage" :
					String pckgToDelete = request.getParameter("pckgSelected");
					int pid = PackagesDao.getPid(pckgToDelete);
					//delete the entries corresponding to this pckgid from package channel table
					int noOfRowsDeleted = Package_ChannelDao.deletePid(pid);
					System.out.println("No of rows deleted from package_channel table: " +noOfRowsDeleted);
					//delete the selected pckg frpm package table
					int deletedRowsFrmPkg = PackagesDao.deletePid(pid);
					
					List<String> pkgList = PackagesDao.getPckgNames();
					request.setAttribute("packgList", pkgList);
					url = "/updatePackage.jsp";
					break;
					
				case "editPackage" :
					String pckgToEdit = request.getParameter("pckgSelected");
					Packages pkgObj = new Packages();
					pkgObj = PackagesDao.getPkgDetails(pckgToEdit);
					session.setAttribute("pckgObj", pkgObj);
					session.setAttribute("currPckgName", pkgObj.getp_Name());
					List<String> chnlsOfPckg = Package_ChannelDao.getPckgChanlList(pkgObj.getp_Id());
					request.setAttribute("chnlsOfPckg", chnlsOfPckg);
					List<String> allChnList = ChannelDao.getAllAddChannelsForPid(pkgObj.getp_Id());
					//set the channel list in request
					request.setAttribute("allChnList", allChnList);
					
					url = "/editPackage.jsp";
					break;
					
				case "updatePackageDetails":
					//check for package name update
					String currPkgName = (String) session.getAttribute("currPckgName");
					String pkgNameRecieved = request.getParameter("packageName");
					boolean pkgNameExisits = false;
					if(!currPkgName.equalsIgnoreCase(pkgNameRecieved)){
						List<String> pckNamesList = PackagesDao.getAllPckgNames(currPkgName);
						for(String pkName : pckNamesList){
							pkgNameExisits = pkgNameRecieved.equalsIgnoreCase(pkName);
							if(pkgNameExisits){
								request.setAttribute("msg", "***Package Name Already exists.Please enter a different name***");
								url = "/adminHomePage.jsp";
								break;
							}
							else {
								//update the package details
								//String pkg_Name = request.getParameter("packageName");
								double pkPrice = Double.parseDouble(request.getParameter("price"));
								String pkDesc  = request.getParameter("pckgDesc");
								
								String[] addChannels = request.getParameterValues("allChnl");
								String[] deleteChannels = request.getParameterValues("existingChnl");
	
								//get add and delete channel ids
									List<Integer> addchnlIds = ChannelDao.getChannelIds(addChannels);
									List<Integer> delchnlIds = ChannelDao.getChannelIds(deleteChannels);	
									
									// update description, name and price
									int rowsUpdated = PackagesDao.updatePkgDetails(currPkgName,pkgNameRecieved,pkPrice,pkDesc); 
								
									//get package id
									int pk_id = PackagesDao.getPid(pkgNameRecieved);
									//update add channels
									int updateRowsInserted = Package_ChannelDao.createPckgChnl(pk_id, addchnlIds);
									// update remove channels
									int updateRowsDeleted = Package_ChannelDao.deleteCid(delchnlIds,pk_id);
									
									url = "/adminHomePage.jsp";
									break;
									
								
							}
						}
						break;
						
					}
			
				case "reports":
					url="/reports.jsp";
					break;
					
				case "reportReq":
					String startDate = getFormattedDateStringd(request.getParameter("txtFromDate"))+" 00:00:00";
					System.out.println(startDate);
					String endDate  = getFormattedDateStringd(request.getParameter("txtToDate"))+" 23:59:59";
					System.out.println(endDate);
					String reportType = request.getParameter("reportType");
					
					
					if(reportType.equals("totalSales")){
						Map<String, Double> resultMap = new HashMap<String, Double>();
						resultMap = PackagesDao.getPckgSalesCount(startDate, endDate);
						for(String key :resultMap.keySet()){
							System.out.println(key+","+resultMap.get(key) );
						}
						session.setAttribute("dataMap", resultMap);
						
					}else if(reportType.equals("salesPerPackg")){
						Map<String, Integer> resultMap = new HashMap<String, Integer>();
						resultMap = PackagesDao.getPckgCount(startDate, endDate);
						for(String key :resultMap.keySet()){
							System.out.println(key+","+resultMap.get(key) );
						}
						session.setAttribute("dataMap", resultMap);
						
					}else if(reportType.equals("totalRegCount")){
						Map<String, Integer> resultMap = new HashMap<String, Integer>();
						resultMap = UserDao.getRegCount(startDate, endDate);
						for(String key :resultMap.keySet()){
							System.out.println(key+","+resultMap.get(key) );
						}
						session.setAttribute("dataMap", resultMap);
						
						
					}
					request.setAttribute("reportType", reportType);
					System.out.println(request.getAttribute("reportType"));
					url = "/reportsView.jsp";
					break;
			}

		}
		RequestDispatcher rd=request.getRequestDispatcher(url);  
		rd.forward(request, response);
		//getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public String getFormattedDateStringd(String dateString){
		Date date;
		String dateString2 ="";
		try {
			date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
			 dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dateString2); // 2011-04-16
		return dateString2;
	}
}


