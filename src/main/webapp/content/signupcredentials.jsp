<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/menu_dashboard.css">
</head>
<body>
<ul style="width: 500px;">

<form action="${pageContext.request.contextPath}/SignupServlet" method="post" style="text-align: center;">
<pre>
<h1 style="text-align: center; color: white;">S I G N    U P</h1>
<input type="text" placeholder="Username" name="username" size="50">


<input type="text" placeholder="Password" size="50">


<input type="password" placeholder="Confirm Password" name="password" size="50">


<input type="submit" value="Create Account" ></pre>
</form>

</ul>
</body>
</html>