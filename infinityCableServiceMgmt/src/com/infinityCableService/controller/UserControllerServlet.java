package com.infinityCableService.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.dao.UserDao;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "";
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
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
							url = "/customerHomePage.jsp";
						} else if (existingUser.getRoleId().equalsIgnoreCase("ADMIN")) {
							System.out.println("***User is ADMIN.***");
							session.setAttribute("theAdmin", existingUser);
							url = "/adminHomePage.jsp";
						}
					}
				} else if (existingUser == null) {
					System.out.println("***User does not exists.***");
					request.setAttribute("msg", "User not registerd");
					url = "/loginPage.jsp";
				}

				break;
			case "signup":
				String fName = request.getParameter("firstName");
				String lName = request.getParameter("lastName");
				email = request.getParameter("email");
				long phoneNo = Long.parseLong(request.getParameter("phoneNumber"));
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				int zipcode = Integer.parseInt(request.getParameter("zipcode"));
				password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirm_password");
				java.util.Date date = new java.util.Date();
				String userCreateDate = new Timestamp(date.getTime()).toString();
				// validate the username, email, password and confirm password
				if ((password != null && !password.isEmpty())
						&& (confirmPassword != null && !confirmPassword.isEmpty())) {
					// check if password and confirm password are same
					if (password.equals(confirmPassword)) {
						System.out.println("Password and Confirm password values are same");
						// create the user
						Long userIDofCust = UserDao.createUser(fName, lName, email, phoneNo, address1, address2, city,
								state, zipcode, password, "CUSTOMER", "ACTIVE", userCreateDate);
						System.out.println("User Successfully registerd. User ID: " + userIDofCust);
						url = "/customerHomePage.jsp";
					} // else return to signup page
					else {
						request.setAttribute("msg", "Password and Confirm Password are not same");
						url = "/signup.jsp";
					}
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
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
