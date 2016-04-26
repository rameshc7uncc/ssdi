<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Insert title here</title>
<style>
.right {
    position: absolute;
    right: 0px;
    width: 150px;
    
    padding: 3px;
}


.button {
    background-color: #778899;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button3 {border-radius: 8px;}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:900px;
    width:200px;
    float:left;
    padding-top:30px;
    padding-left:20px;	      
}
#section {
    width:350px;
    float:left;
    padding-top:40px;
    padding-left:90px;	 	 
}
</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1>Infinity Cable Services</h1>
		</div>
		<div id="slogan">
			
		</div>
	</div>
	<div id="menu">
		<ul>
			<li class="first">
				<a href="adminHomePage.jsp">Home</a>
				</li>
				
			<li style="float:right" class="last">
				<a href="UserControllerServlet?action=logout">Logout</a>
				</li>
		
			
		</ul>
		<br class="clearfix" />
	</div>
	<!-- -header -->

<div id="nav">


<form action="PackagesControllerServlet" method="post">
        <input type="hidden" name="action" value="addNewPackage"></input>
		<input type="submit" class="button button3" value="Add Package      "  ></input>
        
</form>
&nbsp
<form action="PackagesControllerServlet" method="post">
		<input type="hidden" name="action" value="updatePackage"></input>
		<input type="submit"  class="button button3" value="Update Package"  ></input>
</form>
&nbsp
<form action="PackagesControllerServlet" method="post">
        <input type="hidden" name="action" value="reports"></input>
		<input type="submit" class="button button3" value="Reports"  ></input> 
</form>
</div>
<div id="section">
<c:choose>
<c:when test="${reportType == 'totalSales'}" >
<img src="http://localhost:8080/infinityCableServiceMgmt/ChartGenerationControllerServlet?action=totalsale">
</c:when>
<c:when test="${reportType == 'salesPerPackg'}" >
<img src="http://localhost:8080/infinityCableServiceMgmt/ChartGenerationControllerServlet?action=totalpackagesale">
</c:when>
<c:when test="${reportType == 'totalRegCount'}" >
<img src="http://localhost:8080/infinityCableServiceMgmt/ChartGenerationControllerServlet?action=getRegChart">
</c:when>
<c:otherwise>
<p> No reports to View</p>
</c:otherwise>
</c:choose>
</div>
<br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>

<div id="page-bottom">
		
			
			<p>
				Privacy Policy | Terms,Conditions&Policies | Regulatory | Forward-Looking Statements Caution | California Privacy Rights | Website Terms Of Use | Site Map
			</p>
		</div>
		
		<br class="clearfix" />
	</div>
</div>
<div id="footer">
	&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">INFINITY</a>. Photos by <a href="http://fotogrph.com/">Fotogrph</a>.
</div>

</body>
</html>