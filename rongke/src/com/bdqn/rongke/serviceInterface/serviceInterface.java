package com.bdqn.rongke.serviceInterface;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.bdqn.rongke.pojo.User;

public interface serviceInterface {

	//登录
	HashMap login(User u,HttpServletRequest request);
	//注册
	HashMap register(User u,HttpServletRequest request);
}
