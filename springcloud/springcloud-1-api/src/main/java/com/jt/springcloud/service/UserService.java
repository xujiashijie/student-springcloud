package com.jt.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jt.springcloud.pojo.User;
@FeignClient(value="provider-user",fallbackFactory=UserServiceFallbackFactory.class)
public interface UserService {


		
		@RequestMapping(value="/findAll",method=RequestMethod.GET)
		public List<User> findAll();
		
		
		@RequestMapping("/saveUser")
		public String saveUser(@RequestBody User user) ;
		
		@RequestMapping("/delete")
		public String deleteUser(Integer id);
		
		@RequestMapping("/updateUser")
		public String updateUser(@RequestBody User user);
		
		
		
        
}
