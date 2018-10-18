<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
		<html>
			<head>
				<meta charset="UTF-8">
				<title></title>
				<link rel="stylesheet" type="text/css" href="../css/帖子.css" />
				 <link rel="stylesheet" type="text/css" href="../css/jquery.emoji.css"/>
				 <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
				 <link rel="stylesheet" type="text/css" href="../css/index.css"/>
				 <link rel="stylesheet" type="text/css" href="../css/railscasts.css"/>
				<style type="text/css">
				*{
				font:"仿宋";
				}
				
				</style>
			</head>
			
<body>
		
			
				<div id="zero"> 
			
				<div id="one">
					<ul >
						<li style="margin-left: 40%;"><strong>网页</strong></li>
						<li><strong>咨询</strong></li>
						<li><strong>贴吧</strong></li>
						<li><strong>知道</strong></li>
						<li><strong>音乐</strong></li>
						<li><strong>图片</strong></li>
						<li><strong>视频</strong></li>
						<li><strong>地图</strong></li>
						<li><strong>文库</strong></li>
						<li style="text-decoration: none; font-size: 10px;color: gray;">|</li>
						<li>百度首页</li>
						<li><a href="${pageContext.request.contextPath}/jsp/login.jsp">登陆</a></li>
				<li><a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a></li>
				<li>问题反馈</li>
				<li><a href="${pageContext.request.contextPath}/jsp/uploadlmg.jsp">更换头像</a></li>
					</ul>
				</div>
				<div id="two">
					<ul>
						<li style="margin-left: 20%;margin-top: 25px;"><img src="../images/384754324067682866.png"/></li>
						<li><input type="text" placeholder="漫威" style="width:500px;height:35px;"/></li>
						<li><input type="submit" value="进入贴吧" style="width:80px;height: 41px;background: blue;border: 1px solid white;margin-top: -1px;color: white;;cursor: pointer;"/></li>
						<li><input type="submit;" value="全吧搜索"style="width:80px;height: 39px;color: blue;background: white;border: 1px solid blue;padding-left:10px;cursor: pointer;"/></li>
						<li style="font-size: 12px;text-decoration: underline;margin-top: 45px;cursor: pointer;">高级搜索</li>
					</ul>
				</div>
				
				<div id="fiv">
					<ul>
						<li><img src="../images/timg.jpg" style="width: 55px;margin-left: 20%;"/></li>
						<li style="font-size: 30px;margin-left: 5%;">漫威吧</li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="+关注" style="width: 65px;height: 35px;background: orangered;border: 1px solid whitesmoke;border-radius: 10px;color: white;font-size: 16px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li style="color: gainsboro;">关注:&nbsp;&nbsp;&nbsp;</li>
						<li style="color: orangered;">462,546&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li style="color: gainsboro;">帖子:&nbsp;&nbsp;</li>
						<li style="color: orangered;">1,526,645</li>
						<br />
						<br />
						<br />
						<li style="margin-left: 20%;margin-top: 0px;">这里是漫威漫画大家庭，这里是想法之屋&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li style="color: gray;margin-top: 0px;">目录：<span style="color: blue;">动漫相关</span></li>
						
						<div id="fiv-1">
							<ul>
							<li style="margin-top: -46px;"><input type="submit" value="签到" style="width: 90px;height: 45px;background: lightskyblue;border-radius: 5px;border: 1px solid lightskyblue;color: white;font-size: 18px;"></li>
							<li style="font-size: 12px;margin-left: 110px;margin-top: -40px;">8月29日</li>
							<br />
							<br />
							<li style="font-size: 12px;margin-left: 110px;margin-top: -20px;">漏签<span style="color: red;">0</span>天</li>
							</ul>
						</div>
						<br />
						
					</ul>
				</div>
				<div style="width: 70%;height: 50px;border: 1px solid white ;" id="there">
					<ul>
						<li>看帖</li>
						<li>图片</li>
						<li>精品</li>
						<li>视频</li>
						<li>玩乐</li>
					</ul>
				</div>
				<div style="width: 70%;height: 40px;border: 1px solid gainsboro;background: white;margin-left: 15%;font-size:20px">
				
					<c:forEach begin="1" end="${pageTotal }" var="p">
			<a href="${pageContext.request.contextPath}/huifu?pageNo=${p}">${p}</a>
			
				</c:forEach>
						
					<span>总共${pageTotal }页，共有${row}个回复</span>
				</div>
				<div style="width: 70%;height: 40px;border: 1px solid gainsboro;background: gainsboro;margin-left: 15%;">
					<a href="${pageContext.request.contextPath}/postMess?pid=${post.pid} " style="float: left;"><p></p></a>
				<p style="float: left;font-size:20px">${post.neirong}</p>
			<%-- //	<p style="float: left;">${post.yonghu }</p>  --%>
					
				</div>
				
				<div style="width: 53%;height: 1500px;margin-left: 15%;background: white;" class="nb">
					
						<ul>
						
			<c:forEach items="${lists }" var="posts"  step="1" >
				<c:set var="o" scope="session"  value="0"/>
			
		<div style="border-bottom:1px solid #E0E0E0;width:100%;height:100%;text-align: center;">
			<br>
			<li style="float:left">回复帖子：${posts.title}&nbsp;&nbsp;</li> 
			<br>
			<li style="float:left;margin-left:200px">内容：${posts.rcontent }&nbsp;&nbsp;</li>
			<br>
			<li style="float:left;margin-left:600px">回复人：${posts.name2}&nbsp;&nbsp;</li>
		
			
			<br>
		<div class="replyToReply" id="mm${posts.rid }" style="position:relative;display:none;">
		<br>	
			 <div style="width:400px;height:100%;border:1px solid #F0F8FF;background:white;margin-left:300px;" class="mmmm">
			 
			 <c:forEach items="${posts.list }" var="pos">
			 <div style="height:100%;border-bottom:1px solid #F5F5F5;border-top:1px solid #F5F5F5;background:#F0F8FF">
			 	<li style="float:left;margin-left:0px;">${pos.hmane}:</li>
			 	<br>
			<li style="float:left;margin-left:100px">${pos.rcontent}</li>
			<br>
			<br>
			<br>
			<li style="float:left;margin-left:300px;">${pos.date}</li>
			</div>
			<br>
			</c:forEach> 
			</div> 
	
		<div>
		 <textarea class="form-control" class="cnn" name="replyToReply" id="replyToReply${posts.rid }" rows="1" style="width:300px;;border:1px solid gray;margin-left:355px"></textarea>

            <div class="m-t-70" style=" width:100px;margin-top:-103px;">
                <li class="btn btn-primary m-t-70" id="btnLoad1${posts.rid }" onclick="llll(${posts.rid})" style="margin-left:300px">^_^</li>
		</div>
		<%-- <input type="text"  name="replyToReply" id="replyToReply${posts.rid }" style="position:absolute;width:400px;height:30px;top:180px;left:200px"></input> --%>
				 <li  id="addReply${posts.rid }" onclick="clicks(${posts.rid })" style="font-size:18px;color:blue;cursor: pointer;margin-left:650px;margin-top:-30px">发表</li>	
		 			<li>${bbb }</li>
          		</div>
			</div>
		
			
			<div style="width:270px;height:20px;margin-left:60%;margin-top:10px;">
			<li style="float:left;margin-left:50px;font-size:12px;color:gray">举报|</li>
		<c:set var="o" value="${o+1 }" />
		
			<li style="float:left;margin-left:10px;font-size:12px;color:gray">${o}楼</li>
		
			<li style="float:left;margin-left:10px;font-size:12px;color:gray">回复时间：${posts.date }</li>
			
			<li style="cursor: pointer;float:left;margin-left:5px;font-size:12px;" onclick="gh(${posts.rid})">回复</li>
			
			
		</div>
			
			</div>
			
		
	</c:forEach>
	</ul>
				</div >
				
				<div style=" position: absolute;float:left;width: 235px;height: 1500px;margin-left:916px;margin-top: -1500px;background: white;">
					
					
		<img src="../images/157488446033852784.png">
		<img src="../images/267827566256103669.png" style="margin-top:-10px"/>
		<img src="../images/98ebdef62826ead9e420ca176cbfd63.png" style="margin-top:-10px">
		
		
					
				</div>
				
				<div style="width: 70%;height: 40px;border: 1px solid gainsboro;background: gainsboro;margin-left: 15%;font-size:20px;margin-top:0px">
					
					
					<c:forEach begin="1" end="${pageTotal }" var="p">
			<a href="${pageContext.request.contextPath}/huifu?pageNo=${p}">${p}</a>
				</c:forEach>
					<span></span>
					<span>总共${pageTotal }页，共有${row}个回复</span>
				</div>
				
				<div style="width: 70%;height: 22%;border: 1px solid ghostwhite;background: ghostwhite;margin-left: 15%;">
					
					<ul id="eight-1">
						<li style="background: url(img/postLogo.png)no-repeat 13px 13px ;width: 30px;height: 28px;margin-top: 0px;"></li>
						<li>发起回复</li>
						
						<li style="margin-left: 20%;">发帖请遵守贴吧协议及<a style="text-decoration: underline;">“七条底线”</a></li>
						<li style="text-decoration underline;">贴吧投诉</li>
					</ul>
					<div style="width: 80%;height: 70%;">
						<div>
							<img src="../images/1536804379(1).jpg" />
						</div>
								<form action="${pageContext.request.contextPath}/Reply?pid=" method="post"> 
		
			<textarea rows="15" cols="100" type="text" name="rcontent" placeholder="请输入内容" style="margin-left:10px"></textarea>
		
			<br/>
			<br>
			<td><input type="submit" value="回复" name="bb" style="background: blue;border:1px solid blue;width:50px;height:30px;color:white;border-radius: 10px;"> </td>
			
						<input type="button" style="margin-left: 50%;" value="保存至快速回帖" />
				<p style="color:red;">${mess}</p>
					</div>
				</div>
			

		
	
	 
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script> 
<script  src="../js/jquery.min.js"></script>
<script  src="../js/highlight.pack.js"></script>
<script  src="../js/jquery.emoji.min.js"></script>
<script  src="../js/emoji.list.js"></script>
	<script >
	
	
	
			function clicks(rid){
				//alert(rid);
			
				var sty1="#replyToReply"+rid;
				var reply=$(sty1).val();
		
				//用AJAX实现
				$.ajax({
					//发送路径
					"url":"${pageContext.request.contextPath}/addReplyToReply",
					//发送方式
					"type":"get",
					"data":{"replyContent":reply,"rid":rid},
					"dataType":"json",
					"success":function(datas){
						//获取后台饭回来的数据，包含在dates里面
					//	alert("数据："+datas.flag);
					
					}
				});
				window.location.href="${pageContext.request.contextPath}/postMess";
			};

			 var a=1;
			 function gh(rid){
				var str="#mm"+rid;
				if(a==1){
					$(str).show(500);
					a++;
				}else{
					$(str).hide(500);
					a=1;
				}
				
			};
		  
		/* $(document).ready(function(){
			fresh();
		}); */
		
	/* 	function fresh(){
			var id=".mmmm".attr("rackld");
			$(".mmmm").load("/RackLocations/kczt_refresh/"+id);
			setTimeout("fresh()",500);
		} */
			
			
			
			
			 
			 
			 function llll(rid){
					
					var btn="#btnLoad1"+rid;
					var editor="#replyToReply"+rid;
					$(editor).emoji({
				        button: btn,
				        showTab: false,
				        animation: 'slide',
				        basePath: '../images/emoji',
				        icons: emojiLists   // 注：详见 js/emoji.list.js
				    });
			 
			 }
	</script>
		

		
	
	


</html>