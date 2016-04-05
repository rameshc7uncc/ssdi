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
<center>
<p> Packages Details. </p>
<table>
        <tr>
            <th><font size="2px">Package Name</font></th>
           
            <th><font size="2px">Package Description</font></th>     
            
            <th><font size="2px">Price</font></th>
            
            <th><font size="2px">Subscribe</font></th>
        </tr>
        <c:forEach var="pgObj" items="${pkgObgList}" >
        <tr>
            <td>${pgObj.p_Name}</td>
            <td>${pgObj.p_Description} </td>
            <td>${pgObj.p_Price} </td>
            <td> <form action="CustomerControllerServlet" method="post">
       			 <input type="hidden" name="action" value="addPackageToUser" />
       			 <input type="hidden" name="pckgNameSelected" value="${pgObj.p_Name}" />
				 <input type="submit" class="button button3" value="Order Now">
				 </form>
			 </td>
			 </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>