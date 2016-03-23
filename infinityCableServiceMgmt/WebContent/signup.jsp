<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Infinifty Cable Service</title>
</head>
<body>
<h2>Sign Up</h2>
<form action="UserControllerServlet" method="post">
            <input type="hidden" name="action" value="signup" />
            <label>First Name *</label>
            <input type="text" name="firstName" required/> <br><br>
            <label>Last Name *</label>
            <input type="text" name="lastName" required/> <br><br>
            <label>Email *</label>
            <input type="email" name="email" required/> <br><br>
            <label>Phone Number *</label>
            <input type="text" name="phoneNumber" required/> <br><br>
            <label>Address *</label>
            <input type="text" name="address1" required/> <br><br>
            <label>Address *</label>
            <input type="text" name="address2" required/> <br><br>
            <label>City *</label>
            <input type="text" name="city" required/> <br><br>
            <label>State *</label>
            <input type="text" name="state" required/> <br><br>
            <label>Zip Code *</label>
            <input type="text" name="zipcode" required/> <br><br>
            <label>Password *</label>
            <input type="password" name="password" required/> <br><br>
            <label>Confirm Password *</label>
            <input type="password" name="confirm_password" required /> <br>

            <input type="submit" value="Create Account" id="signup_button">
            <br>

        </form>
        
        <br>
        <p>${msg}</p>

</body>
</html>