package com.mediumcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediumcepte.repository.UserRepository;
import com.medumcepte.model.Tag;
import com.medumcepte.model.User;


@Service
public class UserService {
	
	//userDao object
	@Autowired
	private UserRepository userRepository;
	
	//create user
	public void create(User user)
	{
		userRepository.create(user);
	}
	
	public List<User> getAll()
	{
		return userRepository.findAll();	
	}
	
	//Print all users
	public void printAll()
	{
		getAll().forEach(user -> System.out.println(user.getName()));
	}
	
	public List<User> getFollowedListByMail(String mail)
	{
		return getAll().stream().filter(user -> user.getMail().equals(mail)).findAny().get().getFollowedUserList();
	}
	
	public List<Tag> getFollowedTagListByMail(String mail)
	{
		return getAll().stream().filter(user -> user.getMail().equals(mail)).findAny().get().getFollowedTagsList();
	}

}
