<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> Add a New Package <p>

		<form action="PackagesControllerServlet" method="post">
        <input type="hidden" name="action" value="addPackage" />
            <label>Package Name *</label>
            <input type="text" name="packageName" required/> <br><br>
            <label>Description *</label>
            <input type="text" name="pckgDesc" required/> <br><br>
            <label>Price *</label>
            <input type="text" name="price" required/> <br><br>
            <select name="channelSelection"  multiple="multiple">
            <c:forEach var="channel" items="${channelList}" >
            <option value="${channel}">${channel}</option>>
            </c:forEach>
            </select>
            <input type="submit" value="ADD" >
            <p> ${msg} <p>
        
</form>
</body>
</html>