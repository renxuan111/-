<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆页面</title>
<link rel="stylesheet" href="" />
</head>
<body>
	<div class="as">
	<div>

	</div>
	<div class="bs">
		
			账号：<input type="text" id="a" name="loginName" placeholder="手机号/邮箱/用户名">
			<br/>
			<br>
			<br>
			密码：<input type="password" id="b" name="loginPass" placeholder="密码">
			<br/>
			<tr>
			<td colspan="2"><input type="checkbox" style="width:15px;height:15px;margin-left:50px">下次自动登陆 </td>
			</tr>
			<br/>
			<br>
			<tr >
			<td><input id="cs" type="submit" onclick="kkk()" value="登陆"> </td>
		
			</tr>
		

		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script> 
<script type="text/javascript">
	function kkk(){
		
		var a=$("#a").val();
		var b=$("#b").val();
	
		var c="aaa";
		if(a==c){
			if(b==123){
				alert("对");
			}else{
				alert("密码不对");
			}
		}else{
			alert("账号不对");
		}
		 
	}

</script>
</html>





