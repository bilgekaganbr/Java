package mediumcepte.dao;

import java.util.ArrayList;
import java.util.List;

import mediumcepte.model.Blog;

public class BlogDao {
	
	private static List<Blog> blogList = new ArrayList<>();
	
	public void saveBlog(Blog blog)
	{
		blogList.add(blog);
	}
	
	public List<Blog> findAllBlogs()
	{
		return blogList;
	}
	
	public void deleteBlog(Blog blog)
	{
		blogList.remove(blog);
	}

}
