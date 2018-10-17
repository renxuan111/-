package com.bdqn.rongke.serviceImpl;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bdqn.rongke.daoInterface.rongkeDao;
import com.bdqn.rongke.pojo.User;
import com.bdqn.rongke.serviceInterface.serviceInterface;

@Service("si")
public class ServiceImpl implements serviceInterface{

	//注入dao接口对象
	@Resource(name="rd")
	private rongkeDao rd;
	
	
	//登录
	@Override
	public HashMap login(User u, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		HashMap map = new HashMap();
		User user=rd.loginDao(u);
		map.put("user", user);
		map.put("mess","登录成功");
		map.put("url", "admin");
		return map;
		
	
	}

	//注册
	@Override
	public HashMap register(User u, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		rd.registerDao(u);
		map.put("mess","注册成功");
		map.put("url", "login");
		return map;
	}

}
