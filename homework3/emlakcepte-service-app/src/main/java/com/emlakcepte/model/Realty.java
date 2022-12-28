package com.emlakcepte.model;

import java.time.LocalDateTime;

import com.emlakcepte.enums.RealtyOption;
import com.emlakcepte.enums.RealtyStatus;
import com.emlakcepte.enums.RealtyType;

public class Realty 
{
	
	private int no;
	private String title;
	private LocalDateTime publishedDate;
	private User user;
	private RealtyStatus status;
	private RealtyType type;
	private RealtyOption option;
	private String province;
	private String district;
	
	public Realty() 
	{
		super();
	}

	public Realty(int no, String title, LocalDateTime publishedDate, User user, RealtyStatus status, RealtyType type, 
			RealtyOption option, String province, String district) 
	{
		super();
		this.no = no;
		this.title = title;
		this.publishedDate = publishedDate;
		this.user = user;
		this.status = status;
		this.type = type;
		this.option = option;
		this.province = province;
		this.district = district;
	}

	public int getNo() 
	{
		return no;
	}

	public void setNo(int no) 
	{
		this.no = no;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public LocalDateTime getPublishedDate() 
	{
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) 
	{
		this.publishedDate = publishedDate;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

	public RealtyStatus getStatus() 
	{
		return status;
	}

	public void setStatus(RealtyStatus status) 
	{
		this.status = status;
	}
	
	public RealtyType getType()
	{
		return type;
	}
	
	public void setType(RealtyType type)
	{
		this.type = type;
	}
	
	public RealtyOption getOption()
	{
		return option;
	}
	
	public void setOption(RealtyOption option)
	{
		this.option = option;
	}

	public String getProvince() 
	{
		return province;
	}

	public void setProvince(String province) 
	{
		this.province = province;
	}
	
	public String getDistrict()
	{
		return district;
	}
	
	public void setDistrict(String district)
	{
		this.district = district;
	}

	@Override
	public String toString() {
		return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate + ", user=" + user
				+ ", status=" + status + ", type=" + type + ", option=" + option + ", province=" + province
				+ ", district=" + district + "]";
	}
	
	
	
	
	

}
