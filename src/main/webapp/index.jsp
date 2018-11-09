<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<body>
	<div class="TopBar">
		<c:import url="topbar/menu_dashboard.jsp"></c:import>
	</div>

	<div class="Content">
	    <c:import url="content/credentials.jsp"></c:import>
	</div>

	<div class="Footer">
		<c:import url="footer/footer.jsp"></c:import>
	</div>
</body>
</html>