package com.mediumcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medumcepte.model.Blog;


@Repository
public class BlogRepository {
	
	private static List<Blog> blogList = new ArrayList<>();
	
	public void save(Blog blog)
	{
		blogList.add(blog);
	}
	
	public List<Blog> findAll()
	{
		return blogList;
	}
	
	public void delete(Blog blog)
	{
		blogList.remove(blog);
	}

}
