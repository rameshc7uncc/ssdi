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
Edit a Package
<form action="PackagesControllerServlet" method="post">
        <input type="hidden" name="action" value="updatePackageDetails" />
            <label>Package Name *</label>
            <input type="text" name="packageName" value="${pckgObj.p_Name}" required/> <br><br>
            <label>Description *</label>
            <input type="text" name="pckgDesc"  value="${pckgObj.p_Description}" required/> <br><br>
            <label>Price *</label>
            <input type="text" name="price"  value="${pckgObj.p_Price}" required/> <br><br>
            <br>
            <label>Existing Channels *</label>
            <select name="existingChnl"  multiple="multiple">
            <c:forEach var="chnl" items="${chnlsOfPckg}" >
            <option value="${chnl}">${chnl}</option>>
            </c:forEach>
            </select>
            <br>
            <label>Channels to Add *</label>
            <select name="allChnl"  multiple="multiple">
            <c:forEach var="chnnl" items="${allChnList}" >
            <option value="${chnnl}">${chnnl}</option>>
            </c:forEach>
            </select>
            <br>
            <input type="submit" value="Update" >
            <p> ${msg} <p>
        
</form>

</body>
</html>