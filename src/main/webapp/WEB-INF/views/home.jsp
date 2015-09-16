<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			<label>ID</label>
			<input type="text" name="mail">
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="password">
		</div>
		<input type="submit" value="submit">
	</form>

</body>
</html>
