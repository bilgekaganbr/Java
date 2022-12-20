package mediumcepte.model;

public class Blog {
	
	private String title;
	private User user;
	private String context;
	private BlogType status;
	
	
	public Blog() {
		super();
	}


	public Blog(String title, User user, String context, BlogType status) {
		super();
		this.title = title;
		this.user = user;
		this.context = context;
		this.status = status;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public BlogType getStatus() {
		return status;
	}


	public void setStatus(BlogType status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Blog [title=" + title + ", user=" + user + ", context=" + context + ", status=" + status + "]";
	}
	
	
	
	
	

}
