package com.mediumcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medumcepte.model.User;

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

}
