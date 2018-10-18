package com.bdqn.rongke.BBSSystem.serviceImp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.bdqn.rongke.BBSSystem.daoImp.RegisterDaoImp;
import com.bdqn.rongke.BBSSystem.entity.User;
import com.bdqn.rongke.BBSSystem.entity.Page;
import com.bdqn.rongke.BBSSystem.entity.Post;
import com.bdqn.rongke.BBSSystem.entity.Reply;
import com.bdqn.rongke.BBSSystem.serviceInterface.ServiceInterface;
import java.io.File;

public class ServiceImp implements ServiceInterface{
	
	@Override
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		//����
		String uname=request.getParameter("uname");
		//�绰
		String uphone=request.getParameter("uphone");
		//����
		String upass=request.getParameter("upass");
		//��֤��
		String yzm=request.getParameter("validate");
		//��ȡ�Ự���� session
		HttpSession session = request.getSession();
		//ʵ����Dao��ʵ�������
		RegisterDaoImp rdi=new RegisterDaoImp();
		//ʵ����һ��ʵ�������
		User u=new User();

		//������֤����
		String mess=validate(uname,upass,uphone);
		if(mess=="") {
			//��֤ͨ��
			//��֤�Ƿ�����  ����Dao��q����
			boolean flag=rdi.queryUserByName(uname);
			//�жϷ���ֵ���Ƿ�������
			if(flag) {
				session.setAttribute("mess", "�û����ظ���������ע��");
				//�ض���ע��ҳ��
				
				try {
					response.sendRedirect("jsp/register.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				//ͨ��������֤
				//����ע�᷽�������ע�ᣬ����װ����ת����ҳ
				u.setUname(uname);
				u.setUpass(upass);
				u.setUphone(uphone);
				//����Dao��r��������÷���ֵ
				if(rdi.registerUser(u)) {
					//ע��ɹ�
					session.setAttribute("mess", "ע��ɹ�");
					//ִ�в�ѯ����ѯ�û�����������
					//���û�����session�Ự
					session.setAttribute("temp", u);
					
					try {
						//response.sendRedirect("jsp/login.jsp");
						request.getRequestDispatcher("/login").forward(request, response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					//ע��ʧ��
					session.setAttribute("mess", "���ݿ�ԭ��ע��ʧ�ܣ�������ע��");
					try {
						response.sendRedirect("jsp/register.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else {
			//����֤��Ϣ����session
			session.setAttribute("mess", mess);
			try {
				response.sendRedirect("jsp/register.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//��֤����
	public String validate(String uname,String upass,String uphone) {
		String mess="";
		if(uname!=null && uname!="") {
			if(uphone!=null && uphone!="") {
				if(upass!=null && upass!="") {
					mess="";
				}else {
					mess="���벻��Ϊ�գ�";
					
				}
			}else {
				mess="�绰���벻��Ϊ�գ�";
			}
		}else {
			mess="�û�������Ϊ�գ�";
		}
		return mess;
	}
	//��½����
	@Override
	public void denglu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ����
		String name=request.getParameter("loginName");
		String pass=request.getParameter("loginPass");
		//��ȡ�Ự
		HttpSession session = request.getSession();
		//ʵ����DAO�����
		RegisterDaoImp rdi=new RegisterDaoImp();
		//ʵ����һ��ʵ�������
		User u=new User();

		//������֤����
		String mess=dengluyanzheng(name,pass);
		if(mess=="") {
			//��֤ͨ��
			//����DAO�㷽��
			u=rdi.logins(name, pass,u);
			
			if(u.getUname()!=null) {
				//��½�ɹ�
				session.setAttribute("mess", "��½�ɹ�");
				//ִ�в�ѯ����ѯ�û�����������
				//���û�����session�Ự
				session.setAttribute("temp", u);
				System.out.println(u+"haha");
				//response.sendRedirect("jsp/index.jsp");
				request.getRequestDispatcher("/getindex").forward(request, response);
			}else {
				session.setAttribute("mess", "��½ʧ��");
				response.sendRedirect("jsp/login.jsp");
			}
		}else {
			session.setAttribute("mess", mess);
			response.sendRedirect("jsp/login.jsp");
		}
		
	}
	
	//��½��֤����
	public String dengluyanzheng(String name,String pass) {
		String mass="";
		if(name!=null&&name!="") {
			if(pass!=null&&pass!="") {
				mass="";
			}else {
				mass="���벻��Ϊ��";
			}
		}else {
			mass="�˺Ų���Ϊ��";
		}
		
		return mass;
		
	}
	//��������
	@Override
	public void fatie(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String biao=request.getParameter("biaoti");
		String nei=request.getParameter("neirong");
		//��ȡ�Ự
		HttpSession session = request.getSession();
		//ʵ����DAO�����
		RegisterDaoImp rdi=new RegisterDaoImp();
		//������֤����
		String mass=fatieyanzheng(biao,nei);
		//ʵ����һ��ʵ�������
		User u=new User();

		if(mass=="") {
			//��֤ͨ��
			//����Dao����
			u=(User) session.getAttribute("temp");
			
			boolean df=rdi.fatiezi(biao, nei,u);
			
			if(df) {
				//�����ɹ�
				session.setAttribute("mess", "�����ɹ�");
				//ִ�в�ѯ����ѯ�û�����������
				//���û�����session�Ự
				session.setAttribute("temp", u);
				//response.sendRedirect("jsp/index.jsp");
				request.getRequestDispatcher("/getindex").forward(request, response);
			}else {
				//����ʧ��
				session.setAttribute("mess", "����ʧ�ܣ�δ֪ԭ��");
				response.sendRedirect("jsp/index.jsp");
			}
			
		}else {
			session.setAttribute("mess", mass);
			response.sendRedirect("jsp/index.jsp");
		}
	}
	//������֤����
	public String fatieyanzheng(String biao,String nei) {
		String mass="";
		if(biao!=null&&biao!="") {
			if(nei!=null&&nei!="") {
				mass="";
			}else {
				mass="���ݲ���Ϊ��";
			}
		}else {
			mass="���ⲻ��Ϊ��";
		}
		
		return mass;
		
	}
	//��ʾ����
	@Override
	public void getindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// ʵ���� session
		HttpSession session = request.getSession();
		// ʵ���� dao
		RegisterDaoImp rs = new RegisterDaoImp();
		//��ȡǰ̨��ҳ��
		String pageNo=request.getParameter("pageNo");
		
		//ʵ����һ��page����
		Page page=new Page();
		//���ҳ���pageNoΪ������ʾ��һҳ������
		if(pageNo!=null&&pageNo!="") {
			page.setPageNext(Integer.parseInt(pageNo));
			session.setAttribute("pag", Integer.parseInt(pageNo));
		}else {
			page.setPageNext(0);
			session.setAttribute("pag", 1);
		}
		
		//List  ����
		List list=new ArrayList();
		//���F  dao  �ӷ���
		list=rs.getindex(page);
		
		//��ȡ�ܼ�¼��
		int rows=rs.getrows();
		//��ҳ��
		page.setPageTotal(rows);
		
		if(list!=null) {
			//����ҳ������Ự
			session.setAttribute("pageTotal", page.getPageTotal());
			//���ܼ�¼������session
			session.setAttribute("rows", rows);
			session.setAttribute("list",list);
			response.sendRedirect("jsp/index.jsp");
		}else {
			session.setAttribute("mess","ʧ��");
		}
		
		
}
	//�鿴��������
	@Override
	public void postmess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// ʵ���� dao
		RegisterDaoImp rs = new RegisterDaoImp();
		//��ȡǰ̨��pid
		String pid=request.getParameter("pid");
		
		Post p=(Post) session.getAttribute("post");
		if(pid==null||pid=="") {
			pid=p.getPid()+"";
		}
		
		
		Post post=rs.postmess(Integer.parseInt(pid));
		//�鿴�����ڲ���
		if(post!=null) {
		
			session.setAttribute("post", post);
			session.setAttribute("pid", pid);
			request.getRequestDispatcher("/huifu").forward(request, response);
			
		}else {
			session.setAttribute("bbbb", "�鿴ʧ��");
			response.sendRedirect("jsp/index.jsp");
		}
		
	}
	//�ظ�����
	@Override
	public void addReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// ʵ���� dao
		RegisterDaoImp rs = new RegisterDaoImp();
		//ȡ���Ự����û�����
		User u=(User) session.getAttribute("temp");
		//��ȡ�����Ӷ���
		Post p=(Post) session.getAttribute("post");
		
		//��ȡǰ̨�Ļظ�����
		String rcontent=request.getParameter("rcontent");
		Reply rep=new Reply();
		if(u!=null&&p!=null) {
			if(rcontent!=null&&rcontent!="") {
				rep.setPid(p.getPid());
				rep.setRcontent(rcontent);
				rep.setUid(u.getId());
				
				
				rs.addReply(rep);
				//����ҳ��
				session.setAttribute("mess", "�ظ��ɹ�");
				
				//����ת��
				request.getRequestDispatcher("/postMess").forward(request, response);
				
			}else {
				session.setAttribute("mess", "�ظ�����Ϊ��");
				response.sendRedirect("jsp/postMess.jsp");
			}
			
		}else {
			session.setAttribute("mess", "���޴���");
			response.sendRedirect("jsp/login.jsp");
		}
	}
	//��ʾ�ظ�
	@Override
	public void huifu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// ʵ���� dao
		RegisterDaoImp rs = new RegisterDaoImp();
		Post p=(Post) session.getAttribute("post");
		String pid2=request.getParameter("postpid");
		if(pid2==null || pid2=="") {
			pid2=p.getPid()+"";
		}
		int pid=Integer.parseInt(pid2);
		String pageNo=request.getParameter("pageNo");
			Page page=new Page();
			if(pageNo!=""&&pageNo!=null) {
				page.setPageNext(Integer.parseInt(pageNo));
			}else {
				page.setPageNext(0);
			}
			List list=new ArrayList();
			list=rs.huifub(pid,page);
			
		
			//��ȡ�ܼ�¼��
			int rows=rs.getrow2(pid);
			//��ҳ��
			page.setPageTotal(rows);
			
			
			if(list!=null) {
				//����ҳ������Ự
				session.setAttribute("pageTotal", page.getPageTotal());
				//���ܼ�¼������session
				session.setAttribute("row", rows);
				session.setAttribute("lists",list);
				
				response.sendRedirect("jsp/postMess.jsp");
			}else {
				session.setAttribute("mess", "δ֪����");
				response.sendRedirect("jsp/postMess.jsp");
				
			}
		
		}
	@Override
	public void Mess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		RegisterDaoImp rs = new RegisterDaoImp();
		if(uname!=null&&uname!="") {
			boolean a=rs.queryUserByName(uname);
			if(a) {
				//���� ����true
				response.getWriter().write("true");
			}else {
				
				response.getWriter().write("false");
			}
		}
	}
	@Override
	public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RegisterDaoImp rdi=new RegisterDaoImp();
		//User u=new User();
		//��ȡָ������ͼƬ�ļ���Ŀ¼·��
		String TempPath=request.getServletContext().getRealPath("UserImages");
		System.out.println("·����"+TempPath);
		//����һ����ʱ�ļ�����
		File tempFile=new File(TempPath);
		System.out.println("2");
		//ʵ����һ��ʵ�������
		User u=new User();

		//��������jar���ļ��ϴ������齨
		//ServletFileUpload����������request����
		//FileItemFactory�������Ա��е��ֶν��д���
		//���ļ������ٽ�ֵ���洢�ٴ����ļ���û�г����ʹִ����ڴ�
		DiskFileItemFactory dnf=new DiskFileItemFactory();
		//�ٽ�ֵ
		dnf.setSizeThreshold(4096);
		//�����ٽ�ֵ�����ļ�����
		dnf.setRepository(tempFile);
		System.out.println("3");
		//����ͼƬ���ݵĶ���
		ServletFileUpload upload=new ServletFileUpload(dnf);
		//�����ļ���С
		upload.setFileSizeMax(1024*1024*5);
		System.out.println("4");
		//����ǰ�˵ı����ݣ����ص��������ֶε��б���
		List<FileItem> items=upload.parseRequest(request);
		//ѭ��������ȡ�õ�����
		Iterator it=items.iterator();
		while(it.hasNext()) {
			FileItem fi=(FileItem) it.next();
			//�÷����ж�Ԫ�����ͣ��������ͨ�ֶη���true���ļ�Ԫ������false
			if(fi.isFormField()) {
				//���������ͨ�ֶ�
				//��ȡ�����ı���
				if(fi.getName().equals("title")) {
					String title=fi.getString("tile");
				}
				//������ȡ�������ݵ�
			}else {
				//����������ļ�����
				//��ȡ�û��ϴ����ļ���
				String fileName=fi.getName();
				String prefix=fileName.substring(fileName.lastIndexOf("."));
				System.out.println("��չ���ǣ�"+prefix);
				if(fileName!=null) {
					//ͨ���ļ�������һ���µ�fileʵ��
					File fulleFile=new File(fi.getName());
					//��·������ȡ�ļ����ƣ�������fileʵ����д�뵽�ļ�
					//�����ظ�����ȡ��ǰϵͳ�ĺ��������ټ����ļ���
					Date date=new Date();
					String str=date.getTime()+"";
					//�����·������
					String savePath=str+fulleFile.getName();
					//�����ļ�
					File saveFile=new File(TempPath,savePath);
					//��saveFile�ļ������·��д�뵽���ݿ�
					System.out.println("·���ǣ�"+saveFile.getAbsolutePath());
					//��ȡ�Ự
					HttpSession session=request.getSession();
					u=(User) session.getAttribute("temp");
					//System.out.println(u);
					if(u.getUname()!=null) {
						u.setPicPath(savePath);
						boolean flag=rdi.updateUserImg(u);
						if(flag) {
							//д��
							fi.write(saveFile);
							fi.delete();
							System.out.println("·���ǣ�"+savePath);
							request.getRequestDispatcher("/index").forward(request, response);
						}else {
							response.sendRedirect("jsp/login.jsp");
							session.setAttribute("mess", "û�е�¼�������µ�¼��");
						}
					}else {
						response.sendRedirect("jsp/login.jsp");
						session.setAttribute("mess", "û�е�¼�������µ�¼��");
					}
					
				}
			}
		}
		
	}
	@Override
	public void getReplyToReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String rid2=request.getParameter("rid");
		User u=(User)session.getAttribute("temp");
		Post post =(Post) session.getAttribute("post");
		int uid=u.getId();
		int rid=Integer.parseInt(rid2);
		int pid=post.getPid();
	//	int uid=Integer.parseInt(uid2);
		RegisterDaoImp rdi=new RegisterDaoImp();
		String data=request.getParameter("replyContent");
		if(data!=null) {
		//System.out.println("���ݣ�"+data);
		System.out.println(rid);
		System.out.println(uid);
		System.out.println(data);
		
		boolean flag=rdi.ReplyTo(rid, data, uid,pid);
		
		response.getWriter().write("{\"replyContent\":\""+data+"\""+",\"flag\":"+flag+"}");
		
		
		}else {
			session.setAttribute("bbb", "����Ϊ�գ��ظ�ʧ��");
		}
	}
	
}
	

	
	

		
	

