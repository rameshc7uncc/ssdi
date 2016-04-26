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
	<link
		href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
		rel="stylesheet">
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<!-- Javascript -->
		<script type="text/javascript">
			$(document).ready(
					function() {
						$("#txtFromDate").datepicker(
								{
									numberOfMonths : 2,
									onSelect : function(selected) {
										$("#txtToDate").datepicker("option",
												"minDate", selected)
									}
								});
						$("#txtToDate").datepicker(
								{
									numberOfMonths : 2,
									onSelect : function(selected) {
										$("#txtFromDate").datepicker("option",
												"maxDate", selected)
									}
								});
					});
		</script>
		<style>
th, td {
    padding: 10px;
    text-align: left;
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
 
<div id="section">
	<table>
	<form action="PackagesControllerServlet" method="post">
		<input type="hidden" name="action" value="reportReq"></input>
		
			<tr><th>Enter Start Date: </th><th><input type="text" name ="txtFromDate" id="txtFromDate"></th></tr>
		
		
			<tr><th>Enter End Date: </th><th><input type="text" name = "txtToDate" id="txtToDate"></th></tr>
		

		
  <tr><th>&nbsp;</th>
  <th><select name="reportType">
			<option value="" disabled selected>Select Type</option>
			<option value="totalSales" data-class="flag-france">Sales Report</option>
			<option value="salesPerPackg" data-class="flag-brazil">Packages Report</option>
			<option value="totalRegCount" data-class="flag-argentina">Registration Report</option>

		</select></th></tr>
		<tr><th>&nbsp;</th>
		<th><input type="submit" class="buttons button3" value="Submit"></th></tr>
	</form>
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