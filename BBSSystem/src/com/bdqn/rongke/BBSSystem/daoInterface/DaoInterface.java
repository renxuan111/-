package com.bdqn.rongke.BBSSystem.daoInterface;

import java.util.Date;
import java.util.List;

import com.bdqn.rongke.BBSSystem.entity.Reply;
import com.bdqn.rongke.BBSSystem.entity.Page;
import com.bdqn.rongke.BBSSystem.entity.Post;
import com.bdqn.rongke.BBSSystem.entity.User;

public interface DaoInterface {

	//注册
	public boolean registerUser(User u);
	//验证是否重名的方法，根据用户名来查找
	public boolean queryUserByName(String name);
	//登陆
	public User logins(String name,String pass,User u);
	//发帖
	public  boolean fatiezi(String biao,String nei,User u);
	public List getindex(Page page);
	//帖子详情
	public Post postmess(int pid);
	//根据帖子ID查所有回复
	public List huifub(int pid,Page page);
	
	//添加回复
	public boolean addReply(Reply rep);
	//最后一个回复人
	public List last(int pid);
	//修改个人头像
	public boolean updateUserImg(User u);
	//楼中楼
	public boolean ReplyTo(int rid,String data,int uid,int pid);
	//楼中楼显示
	public List ReplyTo2(int rid);
}
