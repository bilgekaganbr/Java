package emlakceptePattern.service;

import java.util.List;

import emlakceptePattern.dao.RealtyDao;
import emlakceptePattern.model.Realty;
import emlakceptePattern.model.RealtyOption;
import emlakceptePattern.model.RealtyStatus;
import emlakceptePattern.model.RealtyType;
import emlakceptePattern.model.User;
import emlakceptePattern.model.UserType;

public class RealtyService 
{
	//Singleton pattern
	private static RealtyService realtyService = new RealtyService();
	
	//Private constructor for singleton objects
	private RealtyService()
	{
		
	}
	
	//Singleton object generator
	public static RealtyService getRealtyService()
	{
		return realtyService;
	}
	
	//Singleton realtyDao object
	RealtyDao realtyDao = RealtyDao.getRealtyDao();
	
	
	//Function that create realty
	public void createRealty(Realty realty) 
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
				if (realtyDao.findAll().stream().filter(realt -> realt.getUser().equals(realty.getUser())).count() == 3)
				{
					//If it is 3, print a notification and do not create any more realty
					System.out.println("Bireysel kullanıcılar en fazla 3 ilan yayınlayabilir!");
				}
				else
				{
					//Else, create new realty
					realtyDao.saveRealty(realty);
				}
			}
		}
		else
		{
			//If the user is coorporate, create realty limitlessly
			realtyDao.saveRealty(realty);
		}
	}
	
	public List<Realty> getAll()
	{
		return realtyDao.findAll();
	}
	
	//Print all realty
	public void printAll(List<Realty> realtList) 
	{
		realtList.forEach(realty -> System.out.println(realty));
	}
	
	//Print realty by province
	public void getAllByProvince(String province) 
	{
		
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.forEach(realty -> System.out.println(realty));
		
	}
	
	//Print realty by province and district
	public void getAllByProvinceAndDistrict(String province, String district)
	{
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.filter(realty -> realty.getDistrict().equals(district))
		.forEach(realty -> System.out.println(realty));
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
	public List<Realty> getAllByUserName(User user)
	{	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}
	
	//Get active realty by user name
	public List<Realty> getActiveRealtyByUserName(User user) 
	{
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyStatus.ACTIVE.equals(realty.getStatus()))
		.toList();

	}

}
