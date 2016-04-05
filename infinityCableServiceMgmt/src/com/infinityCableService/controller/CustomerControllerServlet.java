package com.infinityCableService.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinityCableService.dao.Customer_SubscriptionDao;
import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.model.Customer_Subscription;
import com.infinityCableService.model.Packages;
import com.infinityCableService.model.User;

/**
 * Servlet implementation class CustomerControllerServlet
 */
//@WebServlet("/CustomerControllerServlet")
public class CustomerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "";
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action == null) {
			url = "/customerHomePage.jsp";
		} else {
			switch (action) {
			case "myProfile":
				
				break;
			
			case "viewPackage":
				List<Packages> pckgsList = PackagesDao.getAllPcgks();
				request.setAttribute("pkgObgList", pckgsList);
				url= "/viewPackage.jsp";
				break;
				
			case "addPackageToUser":
				User user = (User) session.getAttribute("theUser");
				String pckgToAdd = request.getParameter("pckgNameSelected");
				Customer_Subscription cusSubptn = new Customer_Subscription();
				cusSubptn = Customer_SubscriptionDao.getCustomerSubscptnDetails(user.getUserId());
				if(cusSubptn != null){
						if(cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() == null){
							//session.setAttribute("errorMsg", "!!! Kindly unsubscribe from current subscription in order to process new subscription. !!!");
							setAttributesForCustHomePg(user, session);
							url = "/customerHomePage.jsp";
						}else if (cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() != null){
							
						session.setAttribute("pckgToBuy", pckgToAdd);
						url = "/paymentDetailsPage.jsp";
						}
				}else{
					session.setAttribute("pckgToBuy", pckgToAdd);
					url = "/paymentDetailsPage.jsp";
				}
				break;
			
			case "payToAddPackage":
				// insert record into customer subscription
				User userinfo = (User) session.getAttribute("theUser");
				String pckgName = (String) session.getAttribute("pckgToBuy");
				int pckgID = PackagesDao.getPid(pckgName);
				Customer_SubscriptionDao.createCusSubscription(userinfo.getUserId(), pckgID);
				setAttributesForCustHomePg(userinfo, session);
				url = "/customerHomePage.jsp";
				break;
				
			case "unsubscribe":
				// update customer subscription table
				User userDetails = (User) session.getAttribute("theUser");
				String pckgToUpdate = (String) session.getAttribute("currPckgSubscrptn");
				int pid = PackagesDao.getPid(pckgToUpdate);
				int rowUpdated = Customer_SubscriptionDao.unsubscribe(userDetails.getUserId(), pid);
				setAttributesForCustHomePg(userDetails, session);
				url = "/customerHomePage.jsp";
				break;
			
			case "viewBill":
				
				break;
				
			case "help":
				
				break;
	
			
			}
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
	}
	
	public static void setAttributesForCustHomePg (User userinfo, HttpSession session){
		Customer_Subscription cusSubptn = new Customer_Subscription();
		cusSubptn = Customer_SubscriptionDao.getCustomerSubscptnDetails(userinfo.getUserId());
		if(cusSubptn != null){
			if(cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() == null){
				String pckName = PackagesDao.getPckgName(cusSubptn.getP_Id());
				//boolean subscribed = true;
				session.setAttribute("isSubscribed", true);
				session.setAttribute("subscriptionMsg", "*** Currently you have subscribed to "+pckName+" Package. ***");
				session.setAttribute("currPckgSubscrptn",pckName);
			}else if(cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() != null){
				cusSubptn = null;
			}
		}else if(cusSubptn == null){
			System.out.println(" ** Customer has not subscribed to any package");
			session.setAttribute("subscriptionMsg", "*** Currently you have not subscribed any Package. Please click on 'View Package' to subscribe one. ***");
			session.setAttribute("isSubscribed", false);
			
		}
	}

}
