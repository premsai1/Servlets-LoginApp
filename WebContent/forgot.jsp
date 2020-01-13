<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="forgot" method="post">
		<tr>
			<td>Enter the username: <input type="text" name="username"><br>
		</tr>
		<tr>
			<td>Enter the mail : <input type="text" name="mail"><br>
		</tr>
		</td>
		<tr>
			<td>New Password</td>
			<td><input type="password" name="news"></td>
		</tr>
		<br>
		<tr>
			<td>Confirm Password</td>
			<td><input type="password" name="confirm"></td>
		</tr>
		<br>

		<tr>
			<td><input type="submit" value="resetpass"></td>
		</tr>
		<br>
	</form>
</body>
</html>