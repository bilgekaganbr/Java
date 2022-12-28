package com.emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emlakcepte.model.Realty;
import com.emlakcepte.service.RealtyService;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController 
{
	
	@Autowired
	private RealtyService realtyService;
	
	//GET realtyes
	
	@GetMapping
	public List<Realty> getAll()
	{
		return realtyService.getAll();
	}
	
	//POST realtyes
	@PostMapping
	public ResponseEntity<Realty> create(@RequestBody Realty realty)
	{
		realtyService.create(realty);
		return new ResponseEntity<>(realty, HttpStatus.CREATED);
	}
	//Get realtyes by user name
	@GetMapping(value = "/userrealtyes/{name}")
	public List<Realty> getAllByUserName(@PathVariable String name)
	{
		return realtyService.getAllByUserName(name);
	}
	//Get realtyes by province
	@GetMapping(value = "/{province}")
	public List<Realty> getByProvince(@PathVariable String province)
	{
		return realtyService.getAllByProvince(province); 
	}
	//Get realtyes by province and district
	@GetMapping(value = "/{province}/{district}")
	public List<Realty> getByProvinceAndDistrict(@PathVariable String province, @PathVariable String district)
	{
		return realtyService.getAllByProvinceAndDistrict(province, district);
	}
	//Get the number of realtyes by province
	@GetMapping(value = "/numberofrealtyes/{province}")
	public long getNumberByProvince(@PathVariable String province)
	{
		return realtyService.getNumberByProvince(province);
	}
	//Get the number of for sale houses by province
	@GetMapping(value = "/numberofforsalehouses/{province}")
	public long getNumberOfForSaleHouseByProvince(@PathVariable String province)
	{
		return realtyService.getNumberOfForSaleHouseByProvince(province);
	}
	//Get active realtyes by user name
	@GetMapping(value = "/activerealtyes/{name}")
	public List<Realty> getActiveRealtyByUserName(@PathVariable String name)
	{
		return realtyService.getActiveRealtyByUserName(name);
	}
	//Update realty status by email
	@PutMapping(value = "/{email}")
	public Realty updateStatus(@PathVariable String email, @RequestBody Realty realty) //Body of realty with new values
	{
		//Find the realty that wanted to update
		Realty updateRealty = realtyService.getByEmail(email);
		
		//Set new status to the realty that wanted to update
		updateRealty.setStatus(realty.getStatus());
		
		//Create new realty with updated value
		realtyService.create(updateRealty);
		return updateRealty;
	}
	//Delete realty
	@DeleteMapping(value = "/{email}")
	public boolean delete(@PathVariable String email)
	{
		//Find the realty that wanted to delete
		Realty realty = realtyService.getByEmail(email);
		
		realtyService.delete(realty);
		return true;
	}
	

}
