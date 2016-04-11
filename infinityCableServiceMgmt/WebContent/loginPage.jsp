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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Infinity Cable Service</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />


<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="jquery.slidertron-1.1.js"></script>  -->
<!-- <script type="text/javascript">
	$(function() {
		$('#menu > ul').dropotron({
			mode: 'fade',
			globalOffsetY: 11,
			offsetY: -15
		});
		$('#slider').slidertron({
			viewerSelector: '.viewer',
			indicatorSelector: '.indicator span',
			reelSelector: '.reel',
			slidesSelector: '.slide',
			speed: 'slow',
			advanceDelay: 4000
		});
	});
</script>  -->
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
				<a href="index.html">Home</a>
				</li>
			
			
			
			
			
		</ul>
		<br class="clearfix" />
	</div>
	<br></br>
	<div id="login">
     <center>
     <table>
		<form name="loginform" id="loginform" action="UserControllerServlet" method="post">
			<input type="hidden" name="action" value="login">
			
				<tr><th><label for="email">Email<br></th>
				<th><input name="email" id="email" class="input" size="20" tabindex="10" type="text"></label></th></tr>
				<tr>&nbsp;</tr>
				<tr>&nbsp;</tr>
				<tr>&nbsp;</tr>
		         <tr>&nbsp;</tr>
		         <tr>&nbsp;</tr>
		         <tr>&nbsp;</tr>
		         <tr>&nbsp;</tr>
			
			<tr><th><label for="password">Password<br></th>
				<th><input name="password" id="password" class="input" value="" size="20" tabindex="20" type="password"></label></th></tr>
			
			<p class="submit">
			<tr><th>&nbsp;</th>
				<th><input name="submit" id="submit" class="buttons button3" value="Log In" tabindex="100" type="submit"></th></tr>
			</p>
			
		</form></center></table>
		<center>
		<p style="">
			<% if(null != request.getAttribute("errorMsg")){
			%>
			<p style="color:red; "> <%=(String)request.getAttribute("errorMsg")%></p>
			<%} %>
		</p>
		  </center> 
		
	<center>	
    <p> <a href="forgotPasswordPage.jsp" >Forgot Password? </a></p>
    <p> New Customer? Please <a href="signup.jsp" >Sign Up </a></p>
    <form name="loginform" id="loginform" action="UserControllerServlet" method="post">
		<input type="hidden" name="action" value="guestUser">
    <p class="submit">
				<input name="submit" id="submit" class="buttons button3" value="Continue as Guest" tabindex="100" type="submit">
			</p>
    </form>
     </div>
	<p>${msg}</p>
	</center>
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