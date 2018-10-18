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
		//姓名
		String uname=request.getParameter("uname");
		//电话
		String uphone=request.getParameter("uphone");
		//密码
		String upass=request.getParameter("upass");
		//验证码
		String yzm=request.getParameter("validate");
		//获取会话对象 session
		HttpSession session = request.getSession();
		//实例化Dao层实现类对象
		RegisterDaoImp rdi=new RegisterDaoImp();
		//实例化一个实体类对象
		User u=new User();

		//调用验证方法
		String mess=validate(uname,upass,uphone);
		if(mess=="") {
			//验证通过
			//验证是否重名  调用Dao的q方法
			boolean flag=rdi.queryUserByName(uname);
			//判断返回值，是否有重名
			if(flag) {
				session.setAttribute("mess", "用户名重复，请重新注册");
				//重定向到注册页面
				
				try {
					response.sendRedirect("jsp/register.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				//通过重名验证
				//调用注册方法，完成注册，并封装，跳转到主页
				u.setUname(uname);
				u.setUpass(upass);
				u.setUphone(uphone);
				//调用Dao的r方法，获得返回值
				if(rdi.registerUser(u)) {
					//注册成功
					session.setAttribute("mess", "注册成功");
					//执行查询，查询用户的所有数据
					//将用户放入session会话
					session.setAttribute("temp", u);
					
					try {
						//response.sendRedirect("jsp/login.jsp");
						request.getRequestDispatcher("/login").forward(request, response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					//注册失败
					session.setAttribute("mess", "数据库原因，注册失败，请重新注册");
					try {
						response.sendRedirect("jsp/register.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else {
			//将验证信息放入session
			session.setAttribute("mess", mess);
			try {
				response.sendRedirect("jsp/register.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//验证方法
	public String validate(String uname,String upass,String uphone) {
		String mess="";
		if(uname!=null && uname!="") {
			if(uphone!=null && uphone!="") {
				if(upass!=null && upass!="") {
					mess="";
				}else {
					mess="密码不能为空！";
					
				}
			}else {
				mess="电话号码不能为空！";
			}
		}else {
			mess="用户名不能为空！";
		}
		return mess;
	}
	//登陆方法
	@Override
	public void denglu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取参数
		String name=request.getParameter("loginName");
		String pass=request.getParameter("loginPass");
		//获取会话
		HttpSession session = request.getSession();
		//实例化DAO层对象
		RegisterDaoImp rdi=new RegisterDaoImp();
		//实例化一个实体类对象
		User u=new User();

		//调用验证方法
		String mess=dengluyanzheng(name,pass);
		if(mess=="") {
			//验证通过
			//调用DAO层方法
			u=rdi.logins(name, pass,u);
			
			if(u.getUname()!=null) {
				//登陆成功
				session.setAttribute("mess", "登陆成功");
				//执行查询，查询用户的所有数据
				//将用户放入session会话
				session.setAttribute("temp", u);
				System.out.println(u+"haha");
				//response.sendRedirect("jsp/index.jsp");
				request.getRequestDispatcher("/getindex").forward(request, response);
			}else {
				session.setAttribute("mess", "登陆失败");
				response.sendRedirect("jsp/login.jsp");
			}
		}else {
			session.setAttribute("mess", mess);
			response.sendRedirect("jsp/login.jsp");
		}
		
	}
	
	//登陆验证方法
	public String dengluyanzheng(String name,String pass) {
		String mass="";
		if(name!=null&&name!="") {
			if(pass!=null&&pass!="") {
				mass="";
			}else {
				mass="密码不能为空";
			}
		}else {
			mass="账号不能为空";
		}
		
		return mass;
		
	}
	//发帖方法
	@Override
	public void fatie(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String biao=request.getParameter("biaoti");
		String nei=request.getParameter("neirong");
		//获取会话
		HttpSession session = request.getSession();
		//实例化DAO层对象
		RegisterDaoImp rdi=new RegisterDaoImp();
		//调用验证方法
		String mass=fatieyanzheng(biao,nei);
		//实例化一个实体类对象
		User u=new User();

		if(mass=="") {
			//验证通过
			//调用Dao方法
			u=(User) session.getAttribute("temp");
			
			boolean df=rdi.fatiezi(biao, nei,u);
			
			if(df) {
				//发帖成功
				session.setAttribute("mess", "发帖成功");
				//执行查询，查询用户的所有数据
				//将用户放入session会话
				session.setAttribute("temp", u);
				//response.sendRedirect("jsp/index.jsp");
				request.getRequestDispatcher("/getindex").forward(request, response);
			}else {
				//发帖失败
				session.setAttribute("mess", "发帖失败，未知原因");
				response.sendRedirect("jsp/index.jsp");
			}
			
		}else {
			session.setAttribute("mess", mass);
			response.sendRedirect("jsp/index.jsp");
		}
	}
	//发帖验证方法
	public String fatieyanzheng(String biao,String nei) {
		String mass="";
		if(biao!=null&&biao!="") {
			if(nei!=null&&nei!="") {
				mass="";
			}else {
				mass="内容不能为空";
			}
		}else {
			mass="标题不能为空";
		}
		
		return mass;
		
	}
	//显示帖子
	@Override
	public void getindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 实例化 session
		HttpSession session = request.getSession();
		// 实例化 dao
		RegisterDaoImp rs = new RegisterDaoImp();
		//获取前台的页数
		String pageNo=request.getParameter("pageNo");
		
		//实例化一个page对象
		Page page=new Page();
		//如果页面的pageNo为空则显示第一页的数据
		if(pageNo!=null&&pageNo!="") {
			page.setPageNext(Integer.parseInt(pageNo));
			session.setAttribute("pag", Integer.parseInt(pageNo));
		}else {
			page.setPageNext(0);
			session.setAttribute("pag", 1);
		}
		
		//List  集合
		List list=new ArrayList();
		//實現  dao  層方法
		list=rs.getindex(page);
		
		//获取总记录数
		int rows=rs.getrows();
		//总页数
		page.setPageTotal(rows);
		
		if(list!=null) {
			//将总页数放入会话
			session.setAttribute("pageTotal", page.getPageTotal());
			//将总记录数放入session
			session.setAttribute("rows", rows);
			session.setAttribute("list",list);
			response.sendRedirect("jsp/index.jsp");
		}else {
			session.setAttribute("mess","失敗");
		}
		
		
}
	//查看帖子详情
	@Override
	public void postmess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// 实例化 dao
		RegisterDaoImp rs = new RegisterDaoImp();
		//获取前台的pid
		String pid=request.getParameter("pid");
		
		Post p=(Post) session.getAttribute("post");
		if(pid==null||pid=="") {
			pid=p.getPid()+"";
		}
		
		
		Post post=rs.postmess(Integer.parseInt(pid));
		//查看帖子在不在
		if(post!=null) {
		
			session.setAttribute("post", post);
			session.setAttribute("pid", pid);
			request.getRequestDispatcher("/huifu").forward(request, response);
			
		}else {
			session.setAttribute("bbbb", "查看失败");
			response.sendRedirect("jsp/index.jsp");
		}
		
	}
	//回复方法
	@Override
	public void addReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// 实例化 dao
		RegisterDaoImp rs = new RegisterDaoImp();
		//取出会话里的用户对象
		User u=(User) session.getAttribute("temp");
		//获取体贴子对象
		Post p=(Post) session.getAttribute("post");
		
		//获取前台的回复内容
		String rcontent=request.getParameter("rcontent");
		Reply rep=new Reply();
		if(u!=null&&p!=null) {
			if(rcontent!=null&&rcontent!="") {
				rep.setPid(p.getPid());
				rep.setRcontent(rcontent);
				rep.setUid(u.getId());
				
				
				rs.addReply(rep);
				//返回页面
				session.setAttribute("mess", "回复成功");
				
				//请求转发
				request.getRequestDispatcher("/postMess").forward(request, response);
				
			}else {
				session.setAttribute("mess", "回复不能为空");
				response.sendRedirect("jsp/postMess.jsp");
			}
			
		}else {
			session.setAttribute("mess", "查无此人");
			response.sendRedirect("jsp/login.jsp");
		}
	}
	//显示回复
	@Override
	public void huifu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// 实例化 dao
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
			
		
			//获取总记录数
			int rows=rs.getrow2(pid);
			//总页数
			page.setPageTotal(rows);
			
			
			if(list!=null) {
				//将总页数放入会话
				session.setAttribute("pageTotal", page.getPageTotal());
				//将总记录数放入session
				session.setAttribute("row", rows);
				session.setAttribute("lists",list);
				
				response.sendRedirect("jsp/postMess.jsp");
			}else {
				session.setAttribute("mess", "未知错误");
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
				//重名 返回true
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
		//获取指定储存图片文件的目录路劲
		String TempPath=request.getServletContext().getRealPath("UserImages");
		System.out.println("路径："+TempPath);
		//生成一个临时文件对象
		File tempFile=new File(TempPath);
		System.out.println("2");
		//实例化一个实体类对象
		User u=new User();

		//引入两个jar。文件上传处理组建
		//ServletFileUpload类用来解析request情求
		//FileItemFactory工厂类会对表单中的字段进行处理
		//当文件超过临界值，存储再磁盘文件。没有超过就粗存再内存
		DiskFileItemFactory dnf=new DiskFileItemFactory();
		//临界值
		dnf.setSizeThreshold(4096);
		//超过临界值存在文件里面
		dnf.setRepository(tempFile);
		System.out.println("3");
		//接受图片数据的对象
		ServletFileUpload upload=new ServletFileUpload(dnf);
		//设置文件大小
		upload.setFileSizeMax(1024*1024*5);
		System.out.println("4");
		//接受前端的表单数据，返回的是数据字段的列表集合
		List<FileItem> items=upload.parseRequest(request);
		//循环迭代，取得迭代器
		Iterator it=items.iterator();
		while(it.hasNext()) {
			FileItem fi=(FileItem) it.next();
			//该方法判断元素类型，如果是普通字段返回true，文件元素则是false
			if(fi.isFormField()) {
				//处理表单的普通字段
				//获取发帖的标题
				if(fi.getName().equals("title")) {
					String title=fi.getString("tile");
				}
				//继续获取发帖内容等
			}else {
				//处理表单里面文件数据
				//获取用户上传的文件名
				String fileName=fi.getName();
				String prefix=fileName.substring(fileName.lastIndexOf("."));
				System.out.println("拓展名是："+prefix);
				if(fileName!=null) {
					//通过文件名创建一个新的file实例
					File fulleFile=new File(fi.getName());
					//从路径中提取文件名称，并创建file实例，写入到文件
					//避免重复，获取当前系统的毫秒数，再加上文件名
					Date date=new Date();
					String str=date.getTime()+"";
					//储存的路劲名字
					String savePath=str+fulleFile.getName();
					//储存文件
					File saveFile=new File(TempPath,savePath);
					//将saveFile文件对象的路径写入到数据库
					System.out.println("路劲是："+saveFile.getAbsolutePath());
					//获取会话
					HttpSession session=request.getSession();
					u=(User) session.getAttribute("temp");
					//System.out.println(u);
					if(u.getUname()!=null) {
						u.setPicPath(savePath);
						boolean flag=rdi.updateUserImg(u);
						if(flag) {
							//写入
							fi.write(saveFile);
							fi.delete();
							System.out.println("路径是："+savePath);
							request.getRequestDispatcher("/index").forward(request, response);
						}else {
							response.sendRedirect("jsp/login.jsp");
							session.setAttribute("mess", "没有登录，请重新登录！");
						}
					}else {
						response.sendRedirect("jsp/login.jsp");
						session.setAttribute("mess", "没有登录，请重新登录！");
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
		//System.out.println("数据："+data);
		System.out.println(rid);
		System.out.println(uid);
		System.out.println(data);
		
		boolean flag=rdi.ReplyTo(rid, data, uid,pid);
		
		response.getWriter().write("{\"replyContent\":\""+data+"\""+",\"flag\":"+flag+"}");
		
		
		}else {
			session.setAttribute("bbb", "内容为空，回复失败");
		}
	}
	
}
	

	
	

		
	

