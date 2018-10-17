<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/register.action" method="post">
		姓名：<input type="text" name="uName">
		<br>
		密码：<input type="password" name="uPass">
		<br>
		<input type="submit" value="注册">
	</form>
	<p>${mess}</p>
</body>
</html>