<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

</head>
<body>
	<div style="margin: auto; width: 100%; text-align: center">
		<form action="login" method="post">
			Enter username : <input type="text" name="uname"> <br>
			Enter password : <input type="password" name="pass"><br>
			<input type="submit" value="login"> <br> If not register
			click <input type=button onClick="location.href='registeration.jsp'"
				value='click here'> <br> Forgot password<input
				type=button onClick="location.href='forgot.jsp'"
				value='forgot password'><br>
		</form>
	</div>
</body>
</html>