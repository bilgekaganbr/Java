package mediumcepte.service;

import java.util.List;

import mediumcepte.dao.BlogDao;
import mediumcepte.model.Blog;
import mediumcepte.model.BlogType;
import mediumcepte.model.User;

public class BlogService {
	
	//blogDao object
	private BlogDao blogDao = new BlogDao();
	
	//create blog
	public void createBlog(Blog blog)
	{
		blogDao.saveBlog(blog);
	}
	
	public List<Blog> getAllBlogs()
	{
		return blogDao.findAllBlogs();
	}
	
	//Print all blogs
	public void printAllBlogs()
	{
		getAllBlogs().forEach(blog -> System.out.println(blog));
	}
	
	//Print all blogs by user name
	public List<Blog> getAllBlogsByUserName(User user)
	{
		return getAllBlogs().stream().filter(blog -> blog.getUser().getName().equals(user.getName())).toList();
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
			for (Blog blg : getAllBlogs())
			{
				//Find blogs that have same user email with user
				if (blg.getUser().getMail().equals(user.getMail()))
				{
					//For these blogs, find blogs that have same title with blog
					if (blg.getTitle().equals(blog.getTitle()))
					{
						//Delete the blog that meeting these conditions and set its status as DELETED. Fİnally, break
						//the loop because there is not anynore blog that meeting same conditions
						blogDao.deleteBlog(blg);
						blg.setStatus(BlogType.DELETED);
						break;
					}
				}
			}
		}
				
					
		
	}

}
