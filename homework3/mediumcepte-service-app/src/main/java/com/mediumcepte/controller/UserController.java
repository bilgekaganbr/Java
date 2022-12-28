package com.mediumcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediumcepte.service.UserService;
import com.medumcepte.model.Tag;
import com.medumcepte.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user)
	{
		userService.create(user);
		return user;
	}
	
	@GetMapping
	public List<User> getAll()
	{
		return userService.getAll();
	}
	//Find the user's following by its email
	@GetMapping(value = "/{mail}/followings")
	public List<User> getFollowedListByMail(@PathVariable String mail)
	{
		return userService.getFollowedListByMail(mail);
	}
	//Fİnd the user's followed tags by its mail
	@GetMapping(value = "/{mail}/followedtags")
	public List<Tag> getFollowedTagListByMail(@PathVariable String mail)
	{
		return userService.getFollowedTagListByMail(mail);
	}
}
