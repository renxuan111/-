package com.bdqn.rongke.BBSSystem.entity;

public class Page {
	//页面大小，显示几行数据
	private int pageSize=5;
	//第几页
	private int pageNo;
	//总页数
	private int pageTotal;
	//下一页第一条数据的序号
	private int pageNext;
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int pageSize, int pageNo, int pageTotal, int pageNext) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.pageTotal = pageTotal;
		this.pageNext = pageNext;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	//总页数的算法
	public void setPageTotal(int rows) {
		
		this.pageTotal = (rows-1)/pageSize+1;
	}
	public int getPageNext() {
		return pageNext;
	}
	//获取下一页的第一行数据
	public void setPageNext(int pageNo) {
		if(pageNo==0) {
			pageNo=1;
			this.pageNext=(pageNo-1)*pageSize;
		}else {
			this.pageNext=(pageNo-1)*pageSize;
		}
		this.pageNext = pageNext;
	}
	
}
