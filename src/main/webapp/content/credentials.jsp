<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/menu_dashboard.css">
</head>
<body>
<ul style="width: 500px;">
<pre>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post" style="text-align: center;">
<h1 style="text-align: center; color: white;">L O G I N</h1>
<input type="text" placeholder="Username" name="username" size="50">


<input type="password" placeholder="Password" name="password" size="50">


<input type="submit" value="Log In" >


<a href="mainpages/signup.jsp"  style="text-align: center; color: white;">Signup</a>
</form>
</pre>
</ul>
</body>
</html>