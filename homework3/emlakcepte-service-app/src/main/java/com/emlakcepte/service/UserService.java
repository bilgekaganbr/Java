package com.emlakcepte.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.repository.UserRepository;


@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	//Function that create user
	public void create(User user) 
	{		
		//Check if user's password is valid
		if (user.getPassword().length() < 5) 
		{
			//If invalid, print a notification and do not create user
			System.out.println("Şifre en az 5 karakterli olmalı");
		}
		else
		{
			//If password is valid, check if user's mail is valid
			if (!(user.getMail().contains("@")) || !(user.getMail().endsWith(".com")))
			{
				//If invalid, print a notification and do not create user
				System.out.println("Geçerli bir mail adresi girin!");
			}
			else
			{
				//If email also valid, create user
				userRepository.create(user);
			}
		}
				
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
	
	public void delete(User user)
	{
		userRepository.delete(user);
	}

	public User getByEmail(String email) {
		return userRepository.findAll().stream().filter(user -> user.getMail().equals(email)).findFirst().get();
	}
	
	public List<Realty> getSavedRealtyesByEmail(String email)
	{
		return getAll().stream().filter(user -> user.getMail().equals(email)).findAny().get().getSavedRealtyList();
	}
	
	

}
