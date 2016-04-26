<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Infinity</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />

<style>
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
.buttons {
    background-color: #778899;
    border: none;
    color: white;
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button3 {border-radius: 8px;
}
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
			
			
			
			
			
			
			<li style="float:right""class="second">
				<a href="UserControllerServlet?action=logout">Logout</a>
				</li>
		</ul>
		<br class="clearfix" />
	</div>
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
	<center>
	<div id="section">
<h2>Edit a Package</h2>
<table>
<form action="PackagesControllerServlet" method="post">
        <input type="hidden" name="action" value="updatePackageDetails" />
            <tr><th><td align="left"><label><font size="4px">Package Name *</font></label></td></th>
            <th><input type="text" name="packageName" value="${pckgObj.p_Name}" required/></th></tr>
            <tr><th>&nbsp;</th></tr>
            <tr><th><td align="left"><label><font size="4px">Description *</font></label></td></th>
            <th><input type="text" name="pckgDesc"  value="${pckgObj.p_Description}" required/></th></tr>
            <tr><th>&nbsp;</th></tr>
            <tr><th><td align="left"><label><font size="4px">Price *</font></label></td></th>
            <th><input type="text" name="price"  value="${pckgObj.p_Price}" required/></th></tr>
            <tr><th>&nbsp;</th></tr>
            <tr><th><td align="left"><label><font size="4px">Existing Channels *</font></label></td></th>
            <th><select name="existingChnl"  multiple="multiple">
            <c:forEach var="chnl" items="${chnlsOfPckg}" >
            <option value="${chnl}">${chnl}</option>>
            </c:forEach>
            </select></th></tr>
            
            <tr><th>&nbsp;</th></tr>
            <tr><th><td align="left"><label><font size="4px">Channels to Add *</font></label></td></th>
            <th><select name="allChnl"  multiple="multiple">
            <c:forEach var="chnnl" items="${allChnList}" >
            <option value="${chnnl}">${chnnl}</option>>
            </c:forEach>
            </select></th></tr>
            <tr><th><td>&nbsp;</td></th></tr>
            <tr><th><td>&nbsp;</td></th>
            <th><input type="submit" class="buttons button3" value="Update" ></th></tr>
            <p> ${msg} <p>
        
</form>
</table>
</div>
</center>
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