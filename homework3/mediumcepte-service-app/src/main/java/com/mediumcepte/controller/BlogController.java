package com.mediumcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediumcepte.service.BlogService;
import com.medumcepte.model.Blog;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController 
{	
	@Autowired
	private BlogService blogService;
	
	@PostMapping
	public Blog create(@RequestBody Blog blog)
	{
		blogService.create(blog);
		return blog;
	}
	
	@GetMapping
	public List<Blog> getAll()
	{
		return blogService.getAll();
	}
	
	@GetMapping(value = "/{name}")
	public List<Blog> getAllByUserName(@PathVariable String name)
	{
		return blogService.getAllByUserName(name);
	}
	//Update blog status
	@PutMapping(value = "/{title}")
	public Blog updateStatus(@PathVariable String title, @RequestBody Blog blog) //Body of blog with new status value
	{
		//Find the blog that wanted to update
		Blog updateStatus = blogService.getByTitle(title);
		
		//Set new status value to the blog that wanted to update
		updateStatus.setStatus(blog.getStatus());
		
		//Create new blog with updated status
		blogService.create(updateStatus);
		return blog;
	}

}
