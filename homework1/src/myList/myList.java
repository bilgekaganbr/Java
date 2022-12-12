package myList;

import java.util.ArrayList;
import java.util.List;

public class myList {
	
	int default_capacity = 5;
	int element = 0;

	List<String> myList = new ArrayList<>(default_capacity);
	
	public void adding(String name)
	{
		if (name.charAt(0) == 'C')
		{
			myList.add(name);
			element++;
		}
		if (element == default_capacity)
		{
			default_capacity += 7;
		}
		
	}
	public void printing()
	{
		System.out.println(myList);
	}
	
	
}
