<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
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
</head>
<body>
	<form action="PackagesControllerServlet" method="post">
		<input type="hidden" name="action" value="reportReq"></input>
		<p>
			Enter Start Date: <input type="text" name ="txtFromDate" id="txtFromDate">
		</p>
		<p>
			Enter End Date: <input type="text" name = "txtToDate" id="txtToDate">
		</p>

		<br> <select name="reportType">
			<option value="" disabled selected>Select Type</option>
			<option value="totalSales" data-class="flag-france">Sales Report</option>
			<option value="salesPerPackg" data-class="flag-brazil">Packages Report</option>
			<option value="totalRegCount" data-class="flag-argentina">Registration Report</option>

		</select><br></br> <input type="submit" class="buttons button3" value="Submit">
	</form>

</body>
</html>