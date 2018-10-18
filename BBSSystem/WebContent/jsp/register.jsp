<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百度账号注册</title>
<link rel="stylesheet" href="../css/网页注册.css" />
</head>
<script type="text/javascript">
		function show(){
			var loginname=document.getElementById("loginName").value;
			var pass=document.getElementById("password").value;
			var pN=document.getElementById("phoneNumber").value;
			var yZm=document.getElementById("yzm").value;
			if(loginname==null || loginname==""){
				alert("登录名不能为空");
			}else if(pass==null || pass==""){
				alert("密码不能为空");
				}else if(pN==null || pN==""){
					alert("手机号不能为空");
				
			}else if(yZm==null || yZm==""){
				alert("验证码不能为空");
			}
					}
	</script>
<body>
     <div class="top">
			<div class="first" style="margin-top:100px;">
			
				<span  ><img src="../images/384754324067682866.png" width="150px"/></span><span class="zore">注册百度账号</span>
			</div>

			<div class="two">
				<div class="five">
					<form action="http://localhost:8080/BBSSystem/register.do" method="post">
						登录名：<input type="text" name="uname" placeholder="请输入登录名" id="loginName" onblur="checkMess()">
						<span id="resText" style="color:red"></span>
						<br>
						<br> 
						&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" name="upass" placeholder="请输入密码" id="password"/>
						<br>
						<br> 
						手机号：<input type="phoneNumber" name="uphone" placeholder="请输入手机号" id="phoneNumber" />
						<br>
						<br> 
						验证码：<input type="yyy" name="yzm" placeholder="请输入验证码"  id="yzm"/>&nbsp;<input type="button" name="btn" value="获取验证码" />
						<br>
						<br>
						<input type="checkbox" name="" />阅读并接受
						<a href="https://passport.baidu.com/static/passpc-account/html/protocal.html">《百度用户协议》</a>
						及<a href="">《百度隐私权保护声明》</a>
						<br>
						<br>
						<input style="width:120px;height:30px;background:greenyellow;" type="submit" name="btn" value="注册" onclick="show()" id="sub"/>
						<input style="width:120px;height:30px;background:greenyellow;" type="reset" value="重置">
					</form>
				</div>
			</div>
			<div class="three" style="margin-top:-100px;"  >
				<div class="four" align="center"><img src="../images/188475564794398294.png" /></div>
			</div>
		</div>
</body>
	<script type="text/javascript">
		function checkMess(){
			//获取用户名
			var uname=document.getElementById("loginName").value;
			//声明一个XMLHttpRequest对象
			var rep=null
			//创建异步提交对象
			if(window.ActiveXObject){
				rep=new ActiveXObject("Microsoft.HTTP");
			}else{
				req=new XMLHttpRequest();
			}
			if (req!=null){
				//发送异步请求            true表示开始执行异步请求
				req.open("get","${pageContext.request.contextPath}/Mess?uname="+uname,true);
				//成功后执行回调函数
				req.onreadystatechange=getMess;
				//发送
				req.send(null);
			}
			//回调函数
			function getMess(){
				//获取后台返回来的信息
				//表示已经完成异步提交，不确定是否被处理
				if(req.readyState==4){
					if(req.status==200){
						//获取后台返回的判断
						if(req.responseText=="true"){
							document.getElementById("sub").disabled=true;
							document.getElementById("resText").innerHTML="该用户名已被注册";
						}else{
							document.getElementById("sub").disabled=false;
							document.getElementById("resText").innerHTML="可以使用";
						}
						
						
					}
				}
			}
		}
	
	</script>












</html>