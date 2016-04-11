<%
String message=(String)request.getAttribute("message");
if(null == message){
    message="";
}
%>

<%
    Object firstName=request.getAttribute("firstName");
    if(firstName == null){
    	firstName ="";
    }
    Object lastName=request.getAttribute("lastName");
    if(lastName == null){
    	lastName ="";
    }


    Object email=request.getAttribute("email");
    if(email == null){
    	email ="";
    }

    Object phoneNumber=request.getAttribute("phoneNumber");
    if(phoneNumber == null){
    	phoneNumber ="";
    }

    Object address1=request.getAttribute("address1");
    if(address1 == null){
    	address1 ="";
    }
    Object address2=request.getAttribute("address2");
    if(address2 == null){
    	address2 ="";
    }

    
    Object city=request.getAttribute("city");
    if(city == null){
    	city ="";
    }

    Object state=request.getAttribute("state");
    if(state == null){
    	state ="";
    }

    Object zipcode=request.getAttribute("zipcode");
    if(zipcode == null){
    	zipcode ="";
    }
%>

<html>
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Infinity</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="stylesheet" href="CommonStyle.css" type="text/css">
<link type="text/css" rel="stylesheet" href="menuStyle.css" media="screen" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="jquery.slidertron-1.1.js"></script>

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
			</li>
			
			
			
			
		</ul>
		<br class="clearfix" />
	</div>
<div id="Registration">
                       

                  
                <form  name="signup"  action="UserControllerServlet" method="post">
                
                <center>
                 <div class="error_strings"><%=message%></div> 
                	<input type="hidden" name="action" value="signup" />
                    <table align="center">
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                         <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">First Name * :</td>
                            <td align="right"><input name="firstName" id="firstName" type="text" value='<%=firstName%>'> </td>
                            <td><div id="form1_name_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                         <tr>
                            <td align="left">Last Name * :</td>
                            <td align="right"><input name="lastName" id="lastName" type="text" value='<%=lastName%>'> </td>
                            <td><div id="form1_name_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">Email * :</td>
                            <td align="right"><input name=email id="email" type="email" value='<%=email%>'> </td>
                            <td><div id="form1_emailId_errorloc" class="error_strings"/></td>
                        </tr>
                         <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                         <tr>
                            <td align="left">Phone Number * :</td>
                            <td align="right"><input name="phoneNumber" id="phoneNumber" type="text" value='<%=phoneNumber%>'> </td>
                            <td><div id="form1_contNo_errorloc" class="error_strings"/> </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">Address1 * :</td>
                            <td align="right"><input name="address1" id="address1" type="text" value='<%=address1%>'> </td>
                            <td><div id="form1_address_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">Address2 * :</td>
                            <td align="right"><input name="address2" id="address2" type="text" value='<%=address2%>'> </td>
                            <td><div id="form1_address_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">City * :</td>
                            <td align="right"><input name="city" id="city" type="text" value='<%=city%>'> </td>
                            <td><div id="form1_address_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">State * :</td>
                            <td align="right"><input name="state" id="state" type="text" value='<%=state%>' > </td>
                            <td><div id="form1_address_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">Zip Code * :</td>
                            <td align="right"><input name="zipcode" id="zipcode" type="text" value='<%=zipcode%>'> </td>
                            <td><div id="form1_address_errorloc" class="error_strings"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td>
                            <td align="right"><input name="password" id="password" type="password"/></td>
                            <td><div id="form1_password_errorloc" class="error_strings" /></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="left">Confirm Password :</td>
                            <td align="right"><input name="confirm_password" id="confirm_password" type="password"/></td>
                            <td><div id="form1_conPassword_errorloc" class="error_strings" /></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        
                   </table>
                   </center>
                   <center>
					<p class="submit">
						<input name="submit" id="submit" class="button-primary" value="Submit" tabindex="100" type="submit">
						</p>
					</center>
                   </form>
                </div>
   
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