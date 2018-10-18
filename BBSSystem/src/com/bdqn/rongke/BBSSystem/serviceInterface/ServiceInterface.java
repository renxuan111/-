package com.bdqn.rongke.BBSSystem.serviceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceInterface {
	
		//注册方法
		public void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//登陆方法
		public void denglu(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//发帖
		public void fatie(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//显示帖子
		public void getindex(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//帖子详情
		public void postmess(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//回复
		public void addReply(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//回复分页
		public void huifu(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//注册前端验证
		public void Mess(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//图片上传
		public void uploadImage(HttpServletRequest request,HttpServletResponse response) throws Exception;
		//楼中楼
		public void getReplyToReply(HttpServletRequest request,HttpServletResponse response) throws Exception;
		
		
}
