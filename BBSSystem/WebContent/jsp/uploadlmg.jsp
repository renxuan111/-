<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 图片上传 -->
			<form action="${pageContext.request.contextPath}/uploadImage" method="post" enctype="multipart/form-data">
				<input type="file" name="file" onchange="imgPreView(this)">
				<br>
				<div style="width:150px;height:150px;border:1px solid gray;padding:50px" >
					<img src="" id="pic" width="100px">
				</div>
				
				<br>
				<input type="submit" value="提交">
			</form>
</body>
<script type="text/javascript">
	function imgPreView(fileDom) {
		// body...
		if(window.FileReader){
			var reader=new FileReader();
		}else{
			alert("不支持");
		}
		var file=fileDom.files[0];
		var imageType=/^image\//;
		if(!imageType.test(file.type)){
			alert("请选择文件");
			return;
		}
		/*  
		reader.onabort=function(e){} 中断
		reader.onloadstart=function(e){} 开始读取
		reader.onprogress=function(e){}正在读取的时候
		reader.onloadend=function(e){}读取完成，不管成功与否
		*/
		//读取完成的时候
		reader.onload=function(e){
			var img=document.getElementById("pic");
			img.src=e.target.result;
			alert("afdba");
		};
		/* 
		base64:以64个可打印的字符来表示二进制
		
		*/
		/* reader.readAsText */
		reader.readAsDataURL(file);

	}
</script>
</html>