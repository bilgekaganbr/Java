package mediumcepte.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mediumcepte.model.Blog;
import mediumcepte.model.BlogType;
import mediumcepte.model.Tag;
import mediumcepte.model.User;
import mediumcepte.service.BlogService;
import mediumcepte.service.UserService;

public class Main {

	public static void main(String[] args) {
		
		//Test users
		User userbilge = new User("Bilge","bilgekaganbr@gmail.com","123456",
				Collections.emptyList(),LocalDateTime.now(),Collections.emptyList(),Collections.emptyList());
		
		User usercem = new User("Cem", "cemdrman@gmail.com","643512",
				Collections.emptyList(),LocalDateTime.now(),Collections.emptyList(),Collections.emptyList());
		
		User userfisun = new User("Fisun","fisunbrk@gmail.com","346123",
				Collections.emptyList(),LocalDateTime.now(),Collections.emptyList(),Collections.emptyList());
		
		
		//Test blogs
		Blog blog1 = new Blog("Blog1",userbilge,"Blog1Context",BlogType.PUBLISHED);
		Blog blog2 = new Blog("Blog2",userbilge,"Blog2Context",BlogType.PUBLISHED);
		Blog blog3 = new Blog("Blog3",userbilge,"Blog3Context",BlogType.DRAFT);
		
		Blog blog4 = new Blog("Blog4",usercem,"Blog4Context",BlogType.PUBLISHED);
		Blog blog5 = new Blog("Blog5",usercem,"Blog5Context",BlogType.PUBLISHED);
		Blog blog6 = new Blog("Blog6",usercem,"Blog6Context",BlogType.DRAFT);
		
		Blog blog7 = new Blog("Blog7",userfisun,"Blog7Context",BlogType.PUBLISHED);
		Blog blog8 = new Blog("Blog8",userfisun,"Blog8Context",BlogType.PUBLISHED);
		Blog blog9 = new Blog("Blog9",userfisun,"Blog9Context",BlogType.DRAFT);
		
		
		//Test tags
		Tag tag1 = new Tag("Computer Science");
		Tag tag2 = new Tag("Mathematics");
		Tag tag3 = new Tag("Physics");
		Tag tag4 = new Tag("Film and Series");
		Tag tag5 = new Tag("Book");
		
		
		//UserService object
		UserService userService = new UserService();
		
		//Create userList
		userService.createUser(userbilge);
		userService.createUser(usercem);
		userService.createUser(userfisun);
		
		//Print all users by name
		//userService.printAllUsers();
		
		//BlogService object
		BlogService blogService = new BlogService();
		
		//Create blogList
		blogService.createBlog(blog1);
		blogService.createBlog(blog2);
		blogService.createBlog(blog3);
		blogService.createBlog(blog4);
		blogService.createBlog(blog5);
		blogService.createBlog(blog6);
		blogService.createBlog(blog7);
		blogService.createBlog(blog8);
		blogService.createBlog(blog9);
		
		//Print all blogs
		//blogService.printAllBlogs();
		
		//Print all blogs by name
		/*System.out.println(blogService.getAllBlogsByUserName(userbilge));
		System.out.println(blogService.getAllBlogsByUserName(usercem));
		System.out.println(blogService.getAllBlogsByUserName(userfisun));*/
		
		//Delete blog, 1.işlemde userbilge'ye ait blog3'ü sildi. 2.işlemde blog4, userbilge'ye ait olmadığı için
		//gerekli yazıyı yazdırdı. 
		/*blogService.deleteBlogs(userbilge, blog3);
		blogService.deleteBlogs(userbilge, blog4); 
		blogService.printAllBlogs();
		System.out.println(blogService.getAllBlogsByUserName(userbilge));*/
		
		//Following tags
		List<Tag> userbilgeFollowingTags = new ArrayList<>();
		List<Tag> usercemFollowingTags = new ArrayList<>();
		List<Tag> userfisunFollowingTags = new ArrayList<>();
		
		userbilgeFollowingTags.add(tag1);
		userbilgeFollowingTags.add(tag2);
		userbilgeFollowingTags.add(tag3);
		userbilge.setFollowedTagsList(userbilgeFollowingTags);
		
		usercemFollowingTags.add(tag1);
		usercemFollowingTags.add(tag2);
		usercem.setFollowedTagsList(usercemFollowingTags);
		
		userfisunFollowingTags.add(tag4);
		userfisunFollowingTags.add(tag5);
		userfisun.setFollowedTagsList(userfisunFollowingTags);
		
		//Print following tags for each user
		/*printTag(userbilgeFollowingTags);
		System.out.println("--------------");
		printTag(usercemFollowingTags);
		System.out.println("--------------");
		printTag(userfisunFollowingTags);*/
		
		//Follow users
		/*List<User> userbilgeFollowings = new ArrayList<>();
		List<User> usercemFollowings = new ArrayList<>();
		List<User> userfisunFollowings = new ArrayList<>();
		
		userbilgeFollowings.addAll(followUser(userbilge,userbilge));
		userbilgeFollowings.addAll(followUser(userbilge,usercem));
		userbilgeFollowings.addAll(followUser(userbilge,userfisun));
		userbilge.setFollowedUserList(userbilgeFollowings);
		userbilge.getFollowedUserList().forEach(user -> System.out.println(user.getName()));
		
		System.out.println("-------------------");
		
		usercemFollowings.addAll(followUser(usercem,userbilge));
		usercemFollowings.addAll(followUser(usercem,usercem));
		usercemFollowings.addAll(followUser(usercem,userfisun));
		usercem.setFollowedUserList(usercemFollowings);
		usercem.getFollowedUserList().forEach(user -> System.out.println(user.getName()));
		
		System.out.println("-------------------");
		
		userfisunFollowings.addAll(followUser(userfisun,userbilge));
		userfisunFollowings.addAll(followUser(userfisun,usercem));
		userfisunFollowings.addAll(followUser(userfisun,userfisun));
		userfisun.setFollowedUserList(userfisunFollowings);
		userfisun.getFollowedUserList().forEach(user -> System.out.println(user.getName()));*/
		
		
	}
	public static void printTag(List<Tag> tagList)
	{
		tagList.forEach(tag -> System.out.println(tag.getName()));
	}
	
	//Follow method. User'ın kendisini takip etmesine izin vermiyor.
	public static List<User> followUser(User follows, User followed)
	{
		List<User> followingList = new ArrayList<>();
		
		if (!(follows.equals(followed)))
		{
			followingList.add(followed);
			return followingList;
		}
		else
		{
			return Collections.emptyList();
		}
	}

}
