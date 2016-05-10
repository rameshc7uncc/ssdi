package com.infinityCableService.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinityCableService.dao.Customer_SubscriptionDao;
import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.dao.UserDao;
import com.infinityCableService.model.Customer_Subscription;
import com.infinityCableService.model.Packages;
import com.infinityCableService.model.User;
import com.infinityCableService.util.SendEmail;
//import com.infinityCableService.util.SendEmail;
/**
 * Servlet implementation class UserControllerServlet
 */

public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserControllerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "";
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		try{
		if (action == null) {
			url = "/loginPage.jsp";
		} else {
			switch (action) {
			case "login":
				
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				// check whether user exists in DB
				
				User existingUser = UserDao.getUserBasedOnEmailAndPswd(email, password);
				if (existingUser != null) {
					if (email.equals(existingUser.getEmailAddress())) {
						
						if (existingUser.getRoleId().equalsIgnoreCase("CUSTOMER")) {
							System.out.println("***User is CUSTOMER.***");
							session.setAttribute("theUser", existingUser);
							//check the customer has subscribed to packages
							Customer_Subscription cusSubptn = new Customer_Subscription();
							cusSubptn = Customer_SubscriptionDao.getCustomerSubscptnDetails(existingUser.getUserId());
							if(cusSubptn != null){
								if(cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() == null){
									String pckName = PackagesDao.getPckgName(cusSubptn.getP_Id());
									session.setAttribute("currPckgSubscrptn", pckName);
									session.setAttribute("isSubscribed", true);
									session.setAttribute("subscriptionMsg", "*** Currently you have subscribed to "+pckName+" Package. ***");	
								}else if(cusSubptn.getStart_Date() != null && cusSubptn.getEnd_Date() != null){
									cusSubptn = null;
								}
							}else if(cusSubptn == null){
								System.out.println(" ** Customer has not subscribed to any package");
								session.setAttribute("subscriptionMsg", "*** Currently you have not subscribed any Package. Please click on 'View Package' to subscribe one. ***");
								session.setAttribute("isSubscribed", false);
							}
							url = "/customerHomePage.jsp";
						} else if (existingUser.getRoleId().equalsIgnoreCase("ADMIN")) {
							System.out.println("***User is ADMIN.***");
							session.setAttribute("theAdmin", existingUser);
							url = "/adminHomePage.jsp";
						}
					}
				} else if (existingUser == null) {
					System.out.println("***User does not exists.***");
					request.setAttribute("msg", "*** User not registerd. ***");
					url = "/loginPage.jsp";
				}

				break;
			case "signup":
				String message;
				String fName = request.getParameter("firstName");
				String lName = request.getParameter("lastName");
				email = request.getParameter("email");
				
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				long phoneNo=0;
				int zipcode=0;
				try{
				phoneNo = Long.parseLong(request.getParameter("phoneNumber"));
				zipcode = Integer.parseInt(request.getParameter("zipcode"));
				
				}
				catch(NumberFormatException e)
				{	
					 message="Please enter only numeric values for Phone Numver and Zip code";
					 setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
			            forwardRequest(request, response, "signup.jsp", message);
			            return;
				}
				password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirm_password");
				java.util.Date date = new java.util.Date();
				String userCreateDate = new Timestamp(date.getTime()).toString();
				// validate the username, email, password and confirm password
				
		        if(null == fName || "".equals(fName) ){
		            message="Please enter your First name.";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        
		        if(null == lName || "".equals(lName) ){
		            message="Please enter your Last name.";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        
		        if(null == email || "".equals(email) ){
		            message="Please enter your EMail ID";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        
		        if(null == address1 || "".equals(address1) ){
		            message="Please enter your Address Line 1";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        
		        if(null == address2 || "".equals(address2) ){
		            message="Please enter your Address Line 2";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        if(null == city || "".equals(city) ){
		            message="Please enter your city";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        if(null == state || "".equals(state) ){
		            message="Please enter your state";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		      
		        if(null == password || "".equals(password) ){
		            message="Please enter your password";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		        if(null == confirmPassword || "".equals(confirmPassword) ){
		            message="Please enter your password in renter field";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }
		       
	
		        if(password.length()<6){
		            message="Please Enter a Password Greater than 6 characters";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }

		        if(!password.equals(confirmPassword)){
		            message="Your Passswords dont match! Please enter again!";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		        }

		        int indexOfAt=email.indexOf("@");
		        int lastIndexOfDot=email.lastIndexOf(".");

		        if(indexOfAt <1 || lastIndexOfDot < indexOfAt+2 || lastIndexOfDot+2 >= email.length()){
		            message="Please Enter Valid E-Mail ID.[username@domain.com]";
		            setAttributesInRequestObject(request,fName,lName,email,phoneNo,address1,address2,city,state,zipcode);
		            forwardRequest(request, response, "signup.jsp", message);
		            return;
		            }

				break;
			case "forgotPassword":
				email = request.getParameter("email");
				// check if user exists in DB
				User validUser = UserDao.verifyUserBasedOnEmail(email);
				if (validUser != null) {
					String newPassword = "qazwsxedc12324";
					// update DB with default password
					int rowUpdate = UserDao.resetPaswd(email, newPassword);
					
					// send email to the user with reset password
					try {
						SendEmail.sendemail(email, newPassword);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					request.setAttribute("msg", "An email has been sent. Please login using your new password ");
					
					url = "/forgotPasswordPage.jsp";
					
				} else if (validUser == null) {
					request.setAttribute("msg", "Invalid Email Address");
					url = "/forgotPasswordPage.jsp";
				}
				break;
				
			case "guestUser":
				
				List<Packages> pckgsList = PackagesDao.getAllPcgks();
								
				request.setAttribute("pkgObgList", pckgsList);
				
				url= "/guestUserPage.jsp";
				break;
			
			case "logout":
				session.invalidate();
                url = "/index.html";
                break;
                
			}
		}
		}catch(Exception e){
			System.out.println("!!Error occured while processing"+" action: "+action+" in UserControllerServlet!!");
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);  
		rd.forward(request, response);
		//getServletContext().getRequestDispatcher(url).forward(request, response);
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
	private void forwardRequest(HttpServletRequest request, HttpServletResponse response, String PageName,
			String message) throws ServletException, IOException {
		  request.setAttribute("message", message);
	        request.getRequestDispatcher(PageName).forward(request, response);
	}
	private void setAttributesInRequestObject(HttpServletRequest request, String fName, String lName, String email,
			long phoneNo, String address1, String address2, String city, String state, int zipcode) {
		// TODO Auto-generated method stub
		request.setAttribute("firstName", fName);
		request.setAttribute("lastName", lName);
        request.setAttribute("email", email);
        request.setAttribute("phoneNumber", phoneNo);
        request.setAttribute("address1", address1);
        request.setAttribute("address2", address2);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("zipcode", zipcode);
	}
}