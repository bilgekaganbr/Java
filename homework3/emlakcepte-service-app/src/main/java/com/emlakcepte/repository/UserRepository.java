package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emlakcepte.model.User;

@Repository
public class UserRepository 
{
	
	private static List<User> userList = new ArrayList<>();

	public void create(User user) 
	{	
		userList.add(user);
	}
	
	public List<User> findAll() 
	{	
		return userList;
	}
	
	public void delete(User user)
	{
		userList.remove(user);
	}

}
