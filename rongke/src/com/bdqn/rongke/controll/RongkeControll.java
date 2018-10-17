package com.bdqn.rongke.controll;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bdqn.rongke.pojo.User;
import com.bdqn.rongke.serviceInterface.serviceInterface;

@Controller
public class RongkeControll {

	@Resource(name="si") 
	private serviceInterface sif;
	
	//前端控制器，接收请求
	
	//登录
	@RequestMapping("/login.action")
	public ModelAndView login(User u,HttpServletRequest request) {
		HashMap result = new HashMap();
		result=sif.login(u, request);
		ModelAndView mav=new ModelAndView();
		mav.addObject(result);
		return new ModelAndView((String)result.get("url"),"data",result);
	}
	
	//注册
	@RequestMapping("/register.action")
	public ModelAndView register(User u,HttpServletRequest request) {
		HashMap result = new HashMap();
		result=sif.register(u, request);
		ModelAndView mav=new ModelAndView();
		mav.addObject(result);
		return new ModelAndView((String)result.get("url"),"data",result);
	}
	
	
	
}
