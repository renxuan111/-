<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆页面</title>
<link rel="stylesheet" href="../css/login.css" />
</head>
<body>
	<div class="as">
	<div>
	<img src="../images/384754324067682866.png">
	</div>
	<div class="bs">
		<form action="http://localhost:8080/BBSSystem/login.do" method="post">
			账号：<input type="text" name="loginName" placeholder="手机号/邮箱/用户名">
			<br/>
			<br>
			<br>
			密码：<input type="password" name="loginPass" placeholder="密码">
			<br/>
			<tr>
			<td colspan="2"><input type="checkbox" style="width:15px;height:15px;margin-left:50px">下次自动登陆 </td>
			</tr>
			<br/>
			<br>
			<tr >
			<td><input id="cs" type="submit" value="登陆"> </td>
			<td><input id="ds" type="reset" value="重置"> </td>
			</tr>
		</from>
		<p style="color:red;">${mess}</p>
		</div>
	</div>
</body>
</html>