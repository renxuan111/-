package com.bdqn.rongke.BBSSystem.serviceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceInterface {
	
		//ע�᷽��
		public void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//��½����
		public void denglu(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//����
		public void fatie(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//��ʾ����
		public void getindex(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//��������
		public void postmess(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//�ظ�
		public void addReply(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//�ظ���ҳ
		public void huifu(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//ע��ǰ����֤
		public void Mess(HttpServletRequest request, HttpServletResponse response) throws Exception;
		//ͼƬ�ϴ�
		public void uploadImage(HttpServletRequest request,HttpServletResponse response) throws Exception;
		//¥��¥
		public void getReplyToReply(HttpServletRequest request,HttpServletResponse response) throws Exception;
		
		
}
