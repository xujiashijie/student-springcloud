package com.jt.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

@RestController
public class UserController {
	
	//private static final String provider_url = "http://localhost:8000";
//	private static final String provider_url = "http://PROVIDER-USER";
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@SuppressWarnings("unchecked")	//压制警告
//	@RequestMapping("/findAll")
//	public List<User> findAll(){
//		
//		return restTemplate.getForObject(provider_url+"/findAll", List.class);
//	}
//	@RequestMapping("/saveUser/{name}/{age}/{sex}")
//	public String saveUser(User user) {
//		String object = restTemplate.postForObject(provider_url+"/saveUser", user, String.class);
//		return object;
//	}

	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")	//压制警告
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
	}
	
	//新增用户
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {
		
		return userService.saveUser(user);
	}
	
	//删除用户信息
	@RequestMapping("/delete/{id}")
	public String delUser(@PathVariable Integer id) {
		
		
		return userService.deleteUser(id);
	}
	
	
	@RequestMapping("/update/{id}/{name}/{age}/{sex}")
	public String updateUser(User user) {
		
		return userService.updateUser(user);
	}
}
