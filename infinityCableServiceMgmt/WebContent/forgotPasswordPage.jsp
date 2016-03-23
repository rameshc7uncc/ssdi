<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Infinity Cable Service</title>
</head>
<body>
<h2>Forgot Password</h2>

	<form action="UserControllerServlet" method="post">
        <input type="hidden" name="action" value="forgotPassword">
        
        <label >Email Address: </label>
        <input type="email" name="email" required/> <br><br>
        
        <label>&nbsp;</label>
        <input type="submit" value="Reset Password"  >
        <br>
       
    </form>
    <p> ${msg}<p>
</body>
</html>