<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Big Business 2.0
Description: A two-column, fixed-width design with a bright color scheme.
Version    : 1.0
Released   : 20120624
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Infinity</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<!-- - --<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="jquery.slidertron-1.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#menu > ul').dropotron({
			mode: 'fade',
			globalOffsetY: 11,
			offsetY: -15
		});
		
	});
</script><!--->
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
    padding: 10px 20px;
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
    padding-left:40px;	 	 
}


 td, th {
   
    padding-left: 20px;
    padding-right: 20px;
    padding-top:10px;
    padding-bottom: 10px;
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
				<a href="customerHomePage.jsp">Home</a>
				</li>
			
			
			
			
			
			<li style="float:right" class="second">
				<a href="index.html">Logout</a>
				</li>
			
		</ul>
		<br class="clearfix" />
	</div>
<div id="nav">
	<form action="CustomerControllerServlet" method="post">
	        <input type="hidden" name="action" value="myProfile"></input>
			<input type="submit" class="button button3" value=" My Profile    "  ></input>
	</form>
	&nbsp
	<form action="CustomerControllerServlet" method="post">
			<input type="hidden" name="action" value="viewPackage"></input>
			<input type="submit"  class="button button3" value=" View Package    "  ></input>
	</form>
	&nbsp
	<form action="CustomerControllerServlet" method="post">
			<input type="hidden" name="action" value="viewBill"></input>
			<input type="button"  class="button button3" value=" View Bill    "  ></input>
	</form>
	&nbsp
	<form action="CustomerControllerServlet" method="post">
			<input type="hidden" name="action" value="help"></input>
			<input type="button"  class="button button3" value=" Help    "  ></input>
	</form>
	</div>
<div id="section">

<center><h2>Packages Details</h2></center>
<table style="width:140%">
        <tr>
            <th><font size="4px">Package Name</font></th>
           
            <th><font size="4px">Package Description</font></th>     
            
            <th><font size="4px">Price</font></th>
            
            <th><font size="4px">Subscribe</font></th>
        </tr>
        <c:forEach var="pgObj" items="${pkgObgList}" >
        <tr>
            <td><font size="4px">${pgObj.p_Name}</font></td>
            <td>${pgObj.p_Description} </td>
            <td>${pgObj.p_Price} </td>
            <td> <form action="CustomerControllerServlet" method="post">
       			 <input type="hidden" name="action" value="addPackageToUser" />
       			 <input type="hidden" name="pckgNameSelected" value="${pgObj.p_Name}" />
				 <input type="submit" class="buttons button3" value="Order Now">
				 </form>
			 </td>
			 </tr>
        </c:forEach>
    </table>

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