package com.emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emlakcepte.model.Message;

@Repository
public class MessageRepository 
{
	private static List<Message> messageList = new ArrayList<>();
	
	public void create(Message message)
	{
		messageList.add(message);
	}
	
	public List<Message> findAll()
	{
		return messageList;
	}
	
	public void delete(Message message)
	{
		messageList.remove(message);
	}
}
