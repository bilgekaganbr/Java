package emlakceptePatternMain;

import emlakceptePattern.model.Message;
import emlakceptePattern.model.Realty;
import emlakceptePattern.model.User;

//Factory class that generate objects
public class Factory {
	
	//User object generator
	public User getUser()
	{
		return new User();
	}
	
	//Realty object generator
	public Realty getRealty()
	{
		return new Realty();
	}
	
	//Message object generator
	public Message getMessage()
	{
		return new Message();
	}

}
