package com.bdqn.rongke.BBSSystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reply {
	
	private int rid;
	//内容
	private String rcontent;
	//回复人
	private int uid;
	//
	private String name2;
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	//回复哪个贴子
	private int pid;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//回复时间
	private Date date;
	//个人头像
	private String picPath;
	//回复回夫人
	private int tid;
	//楼中楼
	private List list=new ArrayList();
	private String hmane;
	public String getHmane() {
		return hmane;
	}
	public void setHmane(String hmane) {
		this.hmane = hmane;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getPicPath() {
			return picPath;
		}
		public void setPicPath(String picPath) {
			this.picPath = picPath;
		}
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rcontent=" + rcontent + ", uid=" + uid + ", pid=" + pid + ", date=" + date
				+ "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int rid, String rcontent, int uid, int pid) {
		super();
		this.rid = rid;
		this.rcontent = rcontent;
		this.uid = uid;
		this.pid = pid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
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
	
}
