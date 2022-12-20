package emlakceptePattern.dao;

import java.util.ArrayList;
import java.util.List;

import emlakceptePattern.model.Realty;

public class RealtyDao 
{
	//Singleton pattern
	private static RealtyDao realtyDao = new RealtyDao();
	
	//Private constructor for singleton objects
	private RealtyDao()
	{
		
	}
	
	//Sİngleton object generator
	public static RealtyDao getRealtyDao()
	{
		return realtyDao;
	}
	
	private static List<Realty> realtyList = new ArrayList<>();
	
	public void saveRealty(Realty realty) 
	{
		realtyList.add(realty);
	}
	
	public List<Realty> findAll()
	{
		return realtyList;
	}

}
