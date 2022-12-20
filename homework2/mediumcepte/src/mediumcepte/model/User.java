package mediumcepte.model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
	
	private String name;
	private String mail;
	private String password;
	private List<Blog> blogList;
	private LocalDateTime createDate;
	private List<User> followedUserList;
	private List<Tag> followedTagsList;
	
	
	public User() {
		super();
	}


	public User(String name, String mail, String password, List<Blog> blogList, LocalDateTime createDate, 
			List<User> followedUserList, List<Tag> followedTagsList) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.blogList = blogList;
		this.createDate = createDate;
		this.followedUserList = followedUserList;
		this.followedTagsList = followedTagsList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Blog> getBlogList() {
		return blogList;
	}


	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public List<User> getFollowedUserList() {
		return followedUserList;
	}


	public void setFollowedUserList(List<User> followedUserList) {
		this.followedUserList = followedUserList;
	}


	public List<Tag> getFollowedTagsList() {
		return followedTagsList;
	}


	public void setFollowedTagsList(List<Tag> followedTagsList) {
		this.followedTagsList = followedTagsList;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", mail=" + mail + "]";
	}
	
	


	
	
	
	
	
	

}
