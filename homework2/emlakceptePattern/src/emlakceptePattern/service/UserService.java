package emlakceptePattern.service;

import java.util.List;

import emlakceptePattern.dao.UserDao;
import emlakceptePattern.model.User;

public class UserService 
{
	//Singleton pattern
	private static UserService userService = new UserService();
	
	//Private constructor for singleton objects
	private UserService()
	{
		
	}
	
	//Singleton object generator
	public static UserService getUserService()
	{
		return userService;
	}
	
	//Singleton userDao object
	UserDao userDao = UserDao.getUserDao();
	
	//Function that create user
	public void createUser(User user) 
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
				userDao.createUser(user);
			}
		}
				
	}
	
	public List<User> getAllUser() 
	{
		return userDao.findAllUsers();
	}
	
	//Print all users
	public void printAllUser() 
	{
		getAllUser().forEach(user -> System.out.println(user.getName()));
	}
	
	public void updatePassword(User user, String newPassword) 
	{
		// önce hangi user bul ve passwordü update et.
	}

}
