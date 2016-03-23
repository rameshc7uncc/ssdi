<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Infinity Cable Service</title>
</head>
<body>
<h1>Infinity Cable Service</h1>
<h2>Login Page</h2>

	<form action="UserControllerServlet" method="post">
        <input type="hidden" name="action" value="login">
        <label >Email Address: </label>
        <input type="email" name="email" required/> <br><br>
        <label >Password: </label>
        <input type="password" name="password" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Login"  >
        <br>
        
    </form>
    <p> <a href="forgotPasswordPage.jsp" >Forgot Password? </a></p>
    <p> New Customer? Please <a href="signup.jsp" >Sign Up </a></p>
        
	<p>${msg}</p>

</body>
</html>