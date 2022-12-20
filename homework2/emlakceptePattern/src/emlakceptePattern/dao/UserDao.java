package emlakceptePattern.dao;

import java.util.ArrayList;
import java.util.List;

import emlakceptePattern.model.User;

public class UserDao 
{
	//Singleton pattern
	private static UserDao userDao = new UserDao();
	
	//Private constructor for singleton objects
	private UserDao()
	{
		
	}
	
	//Singleton object generator
	public static UserDao getUserDao()
	{
		return userDao;
	}
	
	private static List<User> userList = new ArrayList<>();

	public void createUser(User user) 
	{	
		userList.add(user);
	}
	
	public List<User> findAllUsers() 
	{	
		return userList;
	}

}
