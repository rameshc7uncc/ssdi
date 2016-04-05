<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<p> Enter your payment details</p>
	<form  action="CustomerControllerServlet" method="post">
		<input type="hidden" name="action" value="payToAddPackage">
		<label >Name on the Card: </label>
        <input type="text" name="name" required/> <br><br>
        <label >Card Type (Visa/MasterCard): </label>
        <input type="text" name="cardNumber" required/><br>
        <label>&nbsp;</label>
        <label >Card Number: </label>
        <input type="text" name="cardNumber" required/><br>
        <label>&nbsp;</label>
        <label >CVV: </label>
        <input type="text" name="cardNumber" required/><br>
        <label>&nbsp;</label>
        <label >Valid Until (mm/yy): </label>
        <input type="text" name="cardNumber" required/><br>
        <label>&nbsp;</label>
        
        <input type="submit" value="Pay"  >
        <br>
	</form>
</center>
</body>
</html>