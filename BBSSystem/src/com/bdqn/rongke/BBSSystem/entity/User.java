package com.bdqn.rongke.BBSSystem.entity;

public class User {
	//id
	private int id;
	//�û���
	private String uname;
	//�绰
	private String uphone;
	//����
	private String upass;
	//����ͷ��
	private String picPath;
	public String getPicPath() {
			return picPath;
		}
		public void setPicPath(String picPath) {
			this.picPath = picPath;
		}
	public User(String uname, String uphone, String upass) {
		super();
		this.uname = uname;
		this.uphone = uphone;
		this.upass = upass;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", uphone=" + uphone + ", upass=" + upass + "]";
	}
	
	
	
	
}
