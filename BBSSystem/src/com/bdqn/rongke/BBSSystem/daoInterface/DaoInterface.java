package com.bdqn.rongke.BBSSystem.daoInterface;

import java.util.Date;
import java.util.List;

import com.bdqn.rongke.BBSSystem.entity.Reply;
import com.bdqn.rongke.BBSSystem.entity.Page;
import com.bdqn.rongke.BBSSystem.entity.Post;
import com.bdqn.rongke.BBSSystem.entity.User;

public interface DaoInterface {

	//ע��
	public boolean registerUser(User u);
	//��֤�Ƿ������ķ����������û���������
	public boolean queryUserByName(String name);
	//��½
	public User logins(String name,String pass,User u);
	//����
	public  boolean fatiezi(String biao,String nei,User u);
	public List getindex(Page page);
	//��������
	public Post postmess(int pid);
	//��������ID�����лظ�
	public List huifub(int pid,Page page);
	
	//��ӻظ�
	public boolean addReply(Reply rep);
	//���һ���ظ���
	public List last(int pid);
	//�޸ĸ���ͷ��
	public boolean updateUserImg(User u);
	//¥��¥
	public boolean ReplyTo(int rid,String data,int uid,int pid);
	//¥��¥��ʾ
	public List ReplyTo2(int rid);
}
