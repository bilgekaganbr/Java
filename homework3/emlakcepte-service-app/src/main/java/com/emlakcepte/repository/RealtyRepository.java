package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emlakcepte.model.Realty;

@Repository
public class RealtyRepository 
{
	
	private static List<Realty> realtyList = new ArrayList<>();
	
	public void save(Realty realty) 
	{
		realtyList.add(realty);
	}
	
	public List<Realty> findAll()
	{
		return realtyList;
	}
	
	public void delete(Realty realty)
	{
		realtyList.remove(realty);
	}

}
