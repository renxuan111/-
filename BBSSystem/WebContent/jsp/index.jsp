<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="../css/贴吧.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery.emoji.css"/>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../css/railscasts.css"/>

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
				<li ><input type="text" placeholder="漫威" style="width: 500px;height: 35px;"/></li>
				<li style="margin-left: 0px;"><input type="submit" value="进入贴吧" style="width:80px;height: 41px;background: blue;border: 1px solid white;margin-top: -1px;color: white;" /></li>
				<li><input type="submit" value="全吧搜索"style="width:80px;height: 39px;color: blue;background: white;border: 1px solid blue;"/></li>
				<li style="font-size: 12px;text-decoration: underline;margin-top: 45px;">高级搜索</li>
			</ul>
		</div>
		<img src="../images/95cad1c8a786c917fd5b5590c13d70cf3bc7573a.jpg" style="margin-left: 15%;"/>
		<div>
			<img src="../images/timg.jpg" style="margin-left: 16%;margin-top: -85px;border: 5px solid ghostwhite;"/>
		</div>
		<div id="three">
			<ul>
				<li style="margin-left: 5px;margin-top: 5px;"><span>感谢你与本吧的一同成长</span></li>
				<br />
				<li style="color: grey;font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看榜单>></li>
			</ul>
		</div>
		<div id="for">
		<img src="../images/ihome_batou_icon_636b52f.png" style="width: 50px;"/>
		</div>
		
		<div id="fiv">
			<ul>
				<li style="font-size: 30px;margin-left: 20%;">漫威吧</li>
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
			</ul>
		</div>
		<div id="sex">
			<ul>
				<li>看帖</li>
				<li>图片</li>
				<li>精品</li>
				<li>视频</li>
				<li>群组</li>
				<li style="margin-left: 75%;margin-top: -30px;"><input type="text" style="height: 20px;" value="吧内搜索"></li>
				<li style="margin-left: 90%;margin-top: -27px;"><img src="../images/nav_search_internal_bright_6950208.png" ></li>
			</ul>
		</div>
		<div id="seven" style="width:55.5%;border:1px	">
			<ul style="text-">
	<c:forEach items="${list }" var="posts">
			<div style="border-bottom:1px solid #E0E0E0;width:100%;height:150px;text-align: center;">
			<div style="border:1px solid red;width:88px;height:88px;float:left;margin-top:30px;border-radius:45px">
				<img src="../UserImages/${posts.picPath }" style="width:88px;height:88px"/>
			</div>
			<li style="float:left;margin-top:10px;margin-left:50px;font-size:12px;background:#FFEFD5;width:30px;height:20px;border:1px solid gray;border-radius: 5px;text-align: center;"><!-- 回复数： -->${posts.replycont }&nbsp;&nbsp;</li></li>
			<li style="float:left;margin-left:20px;margin-top:10px;font-size:12px;"><!-- 标题： --><a href="${pageContext.request.contextPath}/postMess?pid=${posts.pid}">${posts.biaoti }:&nbsp;&nbsp;&nbsp;</a></li>
			<%-- <p>${post.id }</p> --%>
			<br><br>
			<li style="margin-top:10px;font-size:12px;" class="pcontent"><!-- 内容： -->${posts.neirong}&nbsp;&nbsp;</li>
			
			<li style="float:left;margin-top:10px;margin-left:600px;font-size:12px;"><!-- 发帖人： -->${posts.yonghu }&nbsp;&nbsp;</li>
			<br>
			<li style="margin-left:640px;margin-top:10px;font-size:12px;"><!-- 发帖时间： -->${posts.date}</li>
			<!-- <li style="float:left;margin-top:50px;font-size:12px;">最后回复人：</li> -->
			</div>
	</c:forEach>
		</ul>
		</div>
		<div style="width:236px;height:860px;float:left;margin-left:70.5%;margin-top:-800px">
		<img src="../images/157488446033852784.png">
		<img src="../images/267827566256103669.png" style="margin-top:-10px"/>
		<img src="../images/98ebdef62826ead9e420ca176cbfd63.png" style="margin-top:-10px">
		
		</div>

		<!-- 分页显示 -->
<div id="mn" style="margin-top:-45px;width:55.5%;height:85px;margin-left:15%;text-align: center;background:white;">
<ul style="margin-top:20px">
<a href="${pageContext.request.contextPath}/getindex?pageNo=1"><input "button" value="首页" style="width:40px;cursor: pointer;"/></a>
<input src="button" value="上一页" style="width:40px;cursor: pointer; " id="f"/>
<c:forEach begin="1" end="${pageTotal }" var="p">

	<a id="i" href="${pageContext.request.contextPath}/getindex?pageNo=${p}">${p}</a>
	
</c:forEach>
<input src="button" value="下一页" style="width:40px;cursor: pointer;" id="l"/>
<a href="${pageContext.request.contextPath}/getindex?pageNo=${pageTotal}"><input src="button" value="尾页" style="width:40px;cursor: pointer;"/></a>
<span>&nbsp&nbsp&nbsp&nbsp&nbsp</span>
<span>总共${pageTotal }页，共有${rows}个帖子</span>


</ul>
</div>

		<div id="eight">
			<ul id="eight-1" style="height: 40px;">
				<li style="background: url(../images/postLogo.png)no-repeat 13px 13px ;width: 30px;height: 28px;margin-top: 0px;"></li>
				<li>发表新帖</li>
				<li style="background: url(../images/postLogo.png)no-repeat 13px -29px ;width: 30px;height: 15px;"></li>
				<li>发起投票</li>
				<li style="margin-left: 20%;">发帖请遵守贴吧协议及<a style="text-decoration: underline;">“七条底线”</a></li>
				<li style="text-decoration underline;">贴吧投诉</li>
			</ul>
			<div style="position: relative">
				<form action="http://localhost:8080/BBSSystem/index.do" method="post"> 
				<input type="text" name="biaoti" style="width: 60%;height: 30px;margin-left: 20px;"/><img src="../images/topic.png" style="margin-left: 10px;" />
				<textarea class="form-control" id="cnn" rows="1" cols="10" name="neirong" style="width: 60%;height: 200px;margin-left: 20px;margin-top: 50px;text-align: center;" placeholder="开通超级会员享6倍经验"></textarea>
				<div class="m-t-70" >
                <li class="btn btn-primary m-t-70" id="btnLoad1" onclick="lll()" style="margin-left:100px;margin-top:0px;height:30px;">^_^</li>
            </div>
				<br />
				<input  type="checkbox" style="margin-left: 20px;top:-200px"/>发表后自动分享本帖
				<br />
				<input type="submit" style="position:absolute; background: blue;width: 60px;height: 30px;top: 350px;left: 20px;border: 1px solid blue;border-radius: 10px;color:white" value="发表"/>
				</form>
					<p style="color:red;">${mess}</p>
			</div>
		</div>		
		</div>
	<!-- 	<h2>示例 demo</h2> 
     <div class="col-md-6">
            <h4>文本框 textarea</h4>
             <textarea class="form-control" id="cnn" rows="1" cols="10"></textarea>
            <div class="m-t-70">
                <li class="btn btn-primary m-t-70" id="btnLoad1">表情</li>
            </div>
        </div>  --> 
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script  src="../js/jquery.min.js"></script>
<script  src="../js/highlight.pack.js"></script>
<script  src="../js/jquery.emoji.min.js"></script>
<script  src="../js/emoji.list.js"></script>
<script type="text/javascript">


$(function(){
	
	$("#f").hide();
	$("#l").show(); 
	/* alert(${pageTotal}); */
	   if(${pag}==1||${pag}==null){ 
		 $("#f").hide();
		$("#l").show();
	}else{
		 $("#f").show();
			$("#l").show();
	}
	
	if(${pag}==${pageTotal}){
		$("#f").show();
		$("#l").hide();
	}   
	
});
	$("#f").click(function(){
		window.location.href="${pageContext.request.contextPath}/getindex?pageNo=${pag-1}";
	});
	$("#l").click(function(){
		window.location.href="${pageContext.request.contextPath}/getindex?pageNo=${pag+1}";
	});

	//显示表情
    $(".pcontent").emojiParse({
    	basePath: '../images/emoji',
        icons: emojiLists   // 注：详见 js/emoji.list.js
    });
	
	
	/* 
	 $("#btnLoad1").click(function(){
		
		
	        $("#cnn").emoji({
	            showTab: true,
	            animation: 'fade',
	            basePath: '../images/emoji',
	            icons: emojiLists   // 注：详见 js/emoji.list.js
	        });
	    }); */
	 
	 function lll(){
			
			var btn="#btnLoad1";
			//var editor="#replyToReply";
			$(cnn).emoji({
		        button: btn,
		        showTab: false,
		        animation: 'slide',
		        basePath: '../images/emoji',
		        icons: emojiLists   // 注：详见 js/emoji.list.js
		    });
	 
	 };
	 
	 
	    
/* 
 	reader.onabort=function(e){} 中断
	reader.onloadstsrt=function(e){} 开始读取
	reader.onprogress=function(e){} 正在读取的时候
	reader.onloadend=function(e){} 读取完成，不管成功与否
*/
		

</script>
</html>