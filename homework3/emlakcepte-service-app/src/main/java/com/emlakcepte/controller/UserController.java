package com.emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	//GET /users
	@GetMapping
	public List<User> getAll()
	{
		return userService.getAll();
	}
	
	//POST /users
	@PostMapping
	// @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<User> create(@RequestBody User user)
	{
		userService.create(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	//GET /users/{email} -> /users/bilgekagabr@gmail.com
	
	@GetMapping(value = "/{email}")
	public User getByEmail(@PathVariable String email)
	{
		return userService.getByEmail(email);
	}
	
	//@PathParam
	@GetMapping(value = "/{email}/savedrealtyes")
	public List<Realty> getSavedrealtyesByEmail(@PathVariable String email)
	{
		return userService.getSavedRealtyesByEmail(email);
	}
	//Update user password
	@PutMapping(value = "/{email}")
	public User updatePassword(@PathVariable String email, @RequestBody User user) //Body of user with new password
	{
		//Find the user that wanted to update
		User updatePassword = userService.getByEmail(email);
		
		//Set new password value to the user that want to update
		updatePassword.setPassword(user.getPassword());
		
		//Create new user with new password value
		userService.create(updatePassword);
		return updatePassword;
	}
	//Delete user
	@DeleteMapping(value = "/{email}")
	public boolean delete(@PathVariable String email)
	{
		//Find the user that wanted to delete
		User user = userService.getByEmail(email);
		
		userService.delete(user);
		return true;
	}
}
