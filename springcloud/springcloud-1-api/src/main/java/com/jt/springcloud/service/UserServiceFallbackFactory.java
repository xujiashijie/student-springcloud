package com.jt.springcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jt.springcloud.pojo.User;

import feign.hystrix.FallbackFactory;

@Component		//必须添加该数据
public class UserServiceFallbackFactory implements FallbackFactory<UserService>{

	@Override
	public UserService create(Throwable cause) {
		
		return new UserService() {
			
			@Override
			public String updateUser(User user) {
				
				return "后台服务器异常,用户更新失败"+user.getName();
			}
			
			@Override
			public String saveUser(User user) {
				
				return "后台服务器异常,新增用户失败"+user.getName();
			}
			
			@Override
			public List<User> findAll() {
				User user = new User();
				user.setId(0);
				user.setName("后台服务器异常");
				user.setAge(0);
				user.setSex("");
				List<User> userList = new ArrayList<User>();
				userList.add(user);
				return userList; 
			}
			
			@Override
			public String deleteUser(Integer id) {
				
				return "后台服务器异常,删除用户信息失败"+id;
			}

		

			
		};
	}
}