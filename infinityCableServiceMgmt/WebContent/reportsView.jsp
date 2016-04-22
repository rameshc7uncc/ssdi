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

<c:choose>
<c:when test="${reportType == 'totalSales'}" >
<img>
</c:when>
<c:when test="${reportType == 'salesPerPackg'}" >
<img>
</c:when>
<c:when test="${reportType == 'totalRegCount'}" >
<img src="http://localhost:8080/infinityCableServiceMgmt/ChartGenerationControllerServlet?action=getRegChart">
</c:when>
<c:otherwise>
<p> No reports to View</p>
</c:otherwise>
</c:choose>


</body>
</html>