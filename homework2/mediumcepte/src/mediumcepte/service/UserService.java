package mediumcepte.service;

import java.util.List;

import mediumcepte.dao.UserDao;
import mediumcepte.model.User;

public class UserService {
	
	//userDao object
	private UserDao userDao = new UserDao();
	
	//create user
	public void createUser(User user)
	{
		userDao.createUser(user);
	}
	
	public List<User> getAllUsers()
	{
		return userDao.findAllUsers();	
	}
	
	//Print all users
	public void printAllUsers()
	{
		getAllUsers().forEach(user -> System.out.println(user.getName()));
	}

}
