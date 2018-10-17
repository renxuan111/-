package com.bdqn.rongke.daoInterface;

import org.springframework.stereotype.Repository;

import com.bdqn.rongke.pojo.User;

@Repository("rd")
public interface rongkeDao {

	//登录
	User loginDao(User u);
	//注册
	void registerDao(User u);
}
