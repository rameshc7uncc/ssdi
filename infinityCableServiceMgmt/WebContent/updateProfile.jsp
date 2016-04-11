<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Infinifty Cable Service</title>
 </head>
 <body>
 <h2>Update Profile</h2>
 <form action="CustomerControllerServlet" method="post">
             <input type="hidden" name="action" value="updateDetails" />
             <label>First Name *</label>
             <input type="text" name="firstName" value="${theUser.getFirstName()}"/> <br><br>
             <label>Last Name *</label>
             <input type="text" name="lastName" value="${theUser.getLastName()}"/> <br><br>
             <label>Email *</label>
             <input type="email" name="email" value="${theUser.getEmailAddress()}"/> <br><br>
             <label>Phone Number *</label>
             <input type="text" name="phoneNumber" value="${theUser.getPhoneNumber()}"/> <br><br>
             <label>Address *</label>
             <input type="text" name="address1" value="${theUser.getAddress1()}"/> <br><br>
             <label>Address *</label>
             <input type="text" name="address2" value="${theUser.getAddress2()}"/> <br><br>
             <label>City *</label>
             <input type="text" name="city" value="${theUser.getCity()}"/> <br><br>
             <label>State *</label>
             <input type="text" name="state" value="${theUser.getState()}"/> <br><br>
             <label>Zip Code *</label>
             <input type="text" name="zipcode" value="${theUser.getPinCode()}"/> <br><br>
             <label>Password *</label>
             <input type="password" name="password" value="${theUser.getPassword()}"/> <br><br>
              
             <input type="submit" value="Update" id="signup_button">
             <br>
 
         </form>
         
         <br>
         <p>${msg}</p>
 
 </body>
 </html>