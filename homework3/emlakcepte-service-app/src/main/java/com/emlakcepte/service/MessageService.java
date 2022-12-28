package com.emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emlakcepte.model.Message;
import com.emlakcepte.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired //singleton messageRepository object
	private MessageRepository messageRepository;
	
	public void create(Message message)
	{
		messageRepository.create(message);
	}
	
	public List<Message> getAll()
	{
		return messageRepository.findAll();
	}
	
	public Message getByTitle(String title)
	{
		return getAll().stream().filter(message -> message.getTitle().equals(title)).findAny().get();
	}
	
	public void delete(Message message)
	{
		messageRepository.delete(message);
		
	}
}
