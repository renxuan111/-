package com.bdqn.rongke.BBSSystem.entity;

public class Page {
	//ҳ���С����ʾ��������
	private int pageSize=5;
	//�ڼ�ҳ
	private int pageNo;
	//��ҳ��
	private int pageTotal;
	//��һҳ��һ�����ݵ����
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
	//��ҳ�����㷨
	public void setPageTotal(int rows) {
		
		this.pageTotal = (rows-1)/pageSize+1;
	}
	public int getPageNext() {
		return pageNext;
	}
	//��ȡ��һҳ�ĵ�һ������
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
