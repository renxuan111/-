package com.bdqn.rongke.BBSSystem.entity;

import java.util.Date;

public class Post {
	private String yonghu;
	private String biaoti;
	private String neirong;
	private int uid;
	private int pid;
	private Date date;
	//最后回复人
	private String mname;
	//回复总量
	private int replycont;
	//个人头像
		private String picPath;
	public String getPicPath() {
			return picPath;
		}
		public void setPicPath(String picPath) {
			this.picPath = picPath;
		}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(String yonghu, String biaoti, String neirong, int uid, int pid, Date date, String mname,
			int replycont) {
		super();
		this.yonghu = yonghu;
		this.biaoti = biaoti;
		this.neirong = neirong;
		this.uid = uid;
		this.pid = pid;
		this.date = date;
		this.mname = mname;
		this.replycont = replycont;
	}
	public String getYonghu() {
		return yonghu;
	}
	public void setYonghu(String yonghu) {
		this.yonghu = yonghu;
	}
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getReplycont() {
		return replycont;
	}
	public void setReplycont(int replycont) {
		this.replycont = replycont;
	}
	@Override
	public String toString() {
		return "Post [yonghu=" + yonghu + ", biaoti=" + biaoti + ", neirong=" + neirong + ", uid=" + uid + ", pid="
				+ pid + ", date=" + date + ", mname=" + mname + ", replycont=" + replycont + "]";
	}
	
}
