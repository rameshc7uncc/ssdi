<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Big Business 2.0
Description: A two-column, fixed-width design with a bright color scheme.
Version    : 1.0
Released   : 20120624
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Big Business 2.0 by TEMPLATED</title>
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
			<h1>Infinity Cable</h1>
		</div>
		<div id="slogan">
			
		</div>
	</div>
	<div id="menu">
		<ul>
			<li class="first">
				<a href="index.html">Home</a>
				</li>
		
			
			<li style="float:right" class="second">
				<a href="index.html">Logout</a>
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
<h2>Update Package</h2> 

<table>
        <tr>
            <th><font size="5px">Package Name</font></th>
           
            <th><font size="5px">Update</font></th>     
            
            <th><font size="5px">Delete</font></th>
        </tr>
        <c:forEach var="pckg" items="${packgList}" >
        <tr>
            <td><font size="5px">${pckg}</font></td>
            <td> <form action="PackagesControllerServlet" method="post">
       			 <input type="hidden" name="action" value="editPackage" />
       			 <input type="hidden" name="pckgSelected" value="${pckg}" />
				 <input type="submit" class="buttons button3" value="Edit">
				 </form>
			 </td>
            <td> <form action="PackagesControllerServlet" method="post">
       			 <input type="hidden" name="action" value="deletePackage" />
       			 <input type="hidden" name="pckgSelected" value="${pckg}" />
				 <input type="submit" class="buttons button3" value="Delete">
				 </form>
			</td>
        </c:forEach>
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
