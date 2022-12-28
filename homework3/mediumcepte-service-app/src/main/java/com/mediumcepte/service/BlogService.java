package com.mediumcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediumcepte.enums.BlogType;
import com.mediumcepte.repository.BlogRepository;
import com.medumcepte.model.Blog;
import com.medumcepte.model.User;


@Service
public class BlogService {
	
	//blogDao object
	@Autowired
	private BlogRepository blogRepository;
	
	//create blog
	public void create(Blog blog)
	{
		blogRepository.save(blog);
	}
	
	public List<Blog> getAll()
	{
		return blogRepository.findAll();
	}
	
	//Print all blogs
	public void printAll()
	{
		getAll().forEach(blog -> System.out.println(blog));
	}
	
	//Print all blogs by user name
	public List<Blog> getAllByUserName(String name)
	{
		return getAll().stream().filter(blog -> blog.getUser().getName().equals(name)).toList();
	}
	
	//Zaman probleminden ötürü unique email ve belirli bir kullanıcının blogları için unique bir title varsaydım ama
	//projeyi modifiye etmedim :)
	//delete blog
	public void deleteBlogs(User user, Blog blog)
	{
		//Check if blog and user do not match
		if (!(blog.getUser().equals(user)))
		{
			//If do not match, print a notification
			System.out.println("Böyle bir bloğunuz yok!");
		}
		else
		{
			//If blog and user match, look all blogs
			for (Blog blg : getAll())
			{
				//Find blogs that have same user email with user
				if (blg.getUser().getMail().equals(user.getMail()))
				{
					//For these blogs, find blogs that have same title with blog
					if (blg.getTitle().equals(blog.getTitle()))
					{
						//Delete the blog that meeting these conditions and set its status as DELETED. Fİnally, break
						//the loop because there is not anynore blog that meeting same conditions
						blogRepository.delete(blg);
						blg.setStatus(BlogType.DELETED);
						break;
					}
				}
			}
		}
				
					
		
	}

	public Blog getByTitle(String title) 
	{
		return getAll().stream().filter(blog -> blog.getTitle().equals(title)).findAny().get();
	}

}
