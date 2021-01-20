package com.kayda.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.kayda.user.dto.User;
import com.kayda.user.dto.UserQueryCondition;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@PostMapping
	public User createUser(@RequestBody @Valid User user) {
		user.setId(1);
		System.out.println("create user...id:"+user.getId()+
				",userName:"+user.getUserName()+",password:"+user.getPassword()
				+",birthday:"+user.getBirthday());
		return user;
	}
	
	@PutMapping(value="/{id:\\d+}")
	public User updateUser(@Valid @RequestBody User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().stream().forEach(error->System.out.println(
					error.getDefaultMessage()));
		}
		
		System.out.println("update user...id:"+user.getId()+
				",userName:"+user.getUserName()+",password:"+user.getPassword()
				+",birthday:"+user.getBirthday());
		return user;
	}
	
	@DeleteMapping(value="/{id:\\d+}")
	public void deleteUser(@PathVariable String id) {
		System.out.println("userId:"+id);
	}
	
	//@RequestMapping(value="/user",method=RequestMethod.GET)
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(/* @RequestParam(name = "userName") String username */
			UserQueryCondition userQueryCondition){
		
		System.out.println(ReflectionToStringBuilder.toString
				(userQueryCondition,ToStringStyle.MULTI_LINE_STYLE));
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	
	@GetMapping(value="/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable String id){
		System.out.println("get info func start...");
		User user = new User();
		user.setUserName("kayda");
		return user;
	}

}
