package com.jt.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@HystrixCommand(fallbackMethod="hystrix_findAll")
	@RequestMapping("/findAll")
	public List<User> findAll(){
		/* int a=1/0; */
		return userService.findAll();
	}
	@RequestMapping("/saveUser")
	@HystrixCommand(fallbackMethod="hystrix_saveUser")
	public String  saveUser(@RequestBody User user) {
		int a=1/0;
		userService.saveUser(user);
		return "用户新增完成:"+user.getName();
	}
	
	
	
	public String  hystrix_saveUser(@RequestBody User user) {
		
		return "用户新增失败:"+user.getName();
	}
	public List<User> hystrix_findAll(){
		User user = new User();
		user.setId(0);
		user.setName("后台服务器异常");
		user.setAge(0);
		user.setSex("");
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		return userList; 
	}
}
