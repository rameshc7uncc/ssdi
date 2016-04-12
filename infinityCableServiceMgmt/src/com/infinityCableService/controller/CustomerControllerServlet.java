package com.infinityCableService.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinityCableService.dao.Customer_SubscriptionDao;
import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.dao.PaymentDao;
import com.infinityCableService.dao.UserDao;
import com.infinityCableService.dao.UserFeedbackDao;
import com.infinityCableService.model.Customer_Subscription;
import com.infinityCableService.model.Packages;
import com.infinityCableService.model.Payment;
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
				url= "/updateProfile.jsp";
				break;
				
			case "updateDetails":
				User userCurrObj = (User) session.getAttribute("theUser");
				User updateUser = new User();
				updateUser.setFirstName(request.getParameter("firstName"));
				updateUser.setLastName(request.getParameter("lastName"));
				updateUser.setEmailAddress(request.getParameter("email"));
				updateUser.setPhoneNumber(Long.parseLong(request.getParameter("phoneNumber")));
				updateUser.setAddress1(request.getParameter("address1"));
				updateUser.setAddress2(request.getParameter("address2"));
				updateUser.setCity(request.getParameter("city"));
				updateUser.setState(request.getParameter("state"));
				updateUser.setPinCode(Integer.parseInt(request.getParameter("zipcode")));
				updateUser.setPassword(request.getParameter("password"));
				updateUser.setUserId(userCurrObj.getUserId());
				
				int rowUpdted = UserDao.updateUser(updateUser);
				User updatedUser = UserDao.getUserBasedOnEmailAndPswd(updateUser.getEmailAddress(),updateUser.getPassword());
				session.setAttribute("theUser", updatedUser);
				session.setAttribute("updateSuccessMsg", "Your details have been successfully updated.");
				url= "/updateProfile.jsp";
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
				session.setAttribute("isPayBill", false);
				if(cusSubptn != null){
						if(cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() == null){
							//session.setAttribute("errorMsg", "!!! Kindly unsubscribe from current subscription in order to process new subscription. !!!");
							setAttributesForCustHomePg(user, session);
							url = "/customerHomePage.jsp";
						}else if (cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() != null){
							
						session.setAttribute("pckgToBuy", pckgToAdd);
						session.setAttribute("isPayBill", false);
						url = "/paymentDetailsPage.jsp";
						}
				}else{
					session.setAttribute("pckgToBuy", pckgToAdd);
					url = "/paymentDetailsPage.jsp";
				}
				break;
			
			case "pay":
				User userinfo = (User) session.getAttribute("theUser");
				if((boolean) session.getAttribute("isPayBill")){
					PaymentDao.updatePaymentDetails(userinfo.getUserId());
				}else{
				// insert record into customer subscription
				String pckgName = (String) session.getAttribute("pckgToBuy");
				int pckgID = PackagesDao.getPid(pckgName);
				Customer_SubscriptionDao.createCusSubscription(userinfo.getUserId(), pckgID);
				double pckgP = PackagesDao.getPrice(pckgName);
				PaymentDao.insertPayment(userinfo.getUserId(), pckgP);
				setAttributesForCustHomePg(userinfo, session);
				}
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
				User bUser = (User) session.getAttribute("theUser");
				Payment viewBill = PaymentDao.getBillDetails(bUser.getUserId());
				request.setAttribute("vBill", viewBill);
				session.setAttribute("isPayBill", true);
				url= "/viewBill.jsp";
				break;
				
			case "payBill":
				url = "/paymentDetailsPage.jsp";
				break;
				
			case "help":
				//User userDetails1 = (User) session.getAttribute("theUser");
				//setAttributesForCustHomePg(userDetails1, session);
				url = "/helpDesk.jsp";
				break;
				
			case "isQuery" :
				
				String type = request.getParameter("querytype");
				User userDetails2 = (User) session.getAttribute("theUser");
				 
				java.util.Date date = new java.util.Date();
				String feedbackCreateDate = new Timestamp(date.getTime()).toString();
				
				UserFeedbackDao.createFeedback(userDetails2.getUserId(), type, "Open", feedbackCreateDate, "NULL");
				request.setAttribute("type", type);
				url ="/message.jsp";
				
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
