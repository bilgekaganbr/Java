package com.emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emlakcepte.client.Banner;
import com.emlakcepte.enums.RealtyOption;
import com.emlakcepte.enums.RealtyStatus;
import com.emlakcepte.enums.RealtyType;
import com.emlakcepte.enums.UserType;
import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.repository.RealtyRepository;


@Service
public class RealtyService 
{
	@Autowired
	private RealtyRepository realtyRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	final String ROOT_URI = "http://localhost:8081/banners";
	
	//Function that create realty
	public void create(Realty realty) 
	{	
		//Check if the user is individual
		if (realty.getUser().getType().equals(UserType.INDIVIDUAL))
		{
			//If the user is individual, check his/her realty is house or not
			if (!(realty.getType().equals(RealtyType.HOUSE)))
			{
				//If not house print a notification and do not create realty
				System.out.println("Biresyel kullanıcılar sadece konut ilanı yayınlayabilir!");
			}
			else
			{
				//If realty is house, check the number of realty of this user is 3 or less than 3
				if (realtyRepository.findAll().stream().filter(realt -> realt.getUser().equals(realty.getUser())).count() == 3)
				{
					//If it is 3, print a notification and do not create any more realty
					System.out.println("Bireysel kullanıcılar en fazla 3 ilan yayınlayabilir!");
				}
				else
				{
					//Else, create new realty
					realtyRepository.save(realty);
					//Call the banner service for create a new banner
					ResponseEntity<Banner> response = restTemplate.postForEntity(ROOT_URI, realty, Banner.class);
					System.out.println(response.getBody().getIlanNo());
				}
			}
		}
		else
		{
			//If the user is corporate, create realty limitlessly
			realtyRepository.save(realty);	
			ResponseEntity<Banner> response = restTemplate.postForEntity(ROOT_URI, realty, Banner.class);
			System.out.println(response.getBody().getIlanNo());
		}
		
	}
	
	public List<Realty> getAll()
	{
		return realtyRepository.findAll();
	}
	
	//Print all realty
	public void printAll(List<Realty> realtList) 
	{
		realtList.forEach(realty -> System.out.println(realty));
	}
	
	public void delete(Realty realty)
	{
		realtyRepository.delete(realty);
	}
	
	//Print realty by province
	public List<Realty> getAllByProvince(String province) 
	{
		
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.toList();
		
	}
	
	//Print realty by province and district
	public List<Realty> getAllByProvinceAndDistrict(String province, String district)
	{
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.filter(realty -> realty.getDistrict().equals(district))
		.toList();
	}
	
	//Get the number of realty by province
	public long getNumberByProvince(String province)
	{
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.count();
	}
	
	//Get the number of for sale house realty by province
	public long getNumberOfForSaleHouseByProvince(String province)
	{
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province))
				.filter(realty -> realty.getOption().equals(RealtyOption.FORSALE))
				.filter(realty -> realty.getType().equals(RealtyType.HOUSE))
				.count();
	}
	
	//Get all realty by user name
	public List<Realty> getAllByUserName(String name)
	{	
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(name))
		.toList();		
	}
	
	//Get active realty by user name
	public List<Realty> getActiveRealtyByUserName(String name) 
	{
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(name))
		.filter(realty -> RealtyStatus.ACTIVE.equals(realty.getStatus()))
		.toList();

	}

	public Realty getByEmail(String email) 
	{
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(email)).findAny().get();
	}
	
	

}
