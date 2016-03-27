<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
Update Package page

<table>
        <tr>
            <th>Package Name</th>
            <th>Update</th>     
            <th>Delete</th>
        </tr>
        <c:forEach var="pckg" items="${packgList}" >
        <tr>
            <td>${pckg}</td>
            <td> <form action="PackagesControllerServlet" method="post">
       			 <input type="hidden" name="action" value="editPackage" />
       			 <input type="hidden" name="pckgSelected" value="${pckg}" />
				 <input type="submit" value="Edit">
				 </form>
			 </td>
            <td> <form action="PackagesControllerServlet" method="post">
       			 <input type="hidden" name="action" value="deletePackage" />
       			 <input type="hidden" name="pckgSelected" value="${pckg}" />
				 <input type="submit" value="Delete">
				 </form>
			</td>
        </c:forEach>
    </table>
</body>
</html>