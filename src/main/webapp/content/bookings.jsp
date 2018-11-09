<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<table border="1" cellpadding="5" cellspacing="0.5">
		<tr>
			<th>USER ID</th>
			<th>Customer Name</th>
			<th>D.O.B</th>
			<th>Gender</th>
			<th>Starting Point</th>
			<th>Destination</th>
			<th>Car Selected</th>
			<th>Date Of Journey</th>
			<th>Journey Ending Date</th>
		</tr>
		<tr>
			<td>${sessionScope.customer[0].userId}</td>
			<td>${sessionScope.customer[0].customerName}</td>
			<td>${sessionScope.customer[0].dob}</td>
		</tr>
	</table>
</body>
</html>