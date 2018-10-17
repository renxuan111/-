package com.bdqn.rongke.pojo;

public class User {

	
	private String uName;
	private String uPass;
	public User(String uName, String uPass) {
		super();
		this.uName = uName;
		this.uPass = uPass;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	@Override
	public String toString() {
		return "User [uName=" + uName + ", uPass=" + uPass + "]";
	}
	
}
