package com.emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emlakcepte.model.Message;
import com.emlakcepte.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping
	public Message create(@RequestBody Message message)
	{
		messageService.create(message);
		return message;
	}
	
	@GetMapping
	public List<Message> getAll()
	{
		return messageService.getAll();
	}
	
	@GetMapping(value = "/{title}")
	public Message getByContent(@PathVariable String title)
	{
		return messageService.getByTitle(title);
	}
	
	//update message by its title
	@PutMapping(value = "/{title}")
	public Message updateMessage(@PathVariable String title, @RequestBody Message message) //Message body with updated values
	{
		//Find the message that wanted to update by title
		Message updateMessage = messageService.getByTitle(title);
		
		//Set new values to the message that wanted to update
		updateMessage.setTitle(message.getTitle());
		updateMessage.setContent(message.getContent());
		updateMessage.setFrom(message.getFrom());
		updateMessage.setTo(message.getTo());
		
		//Create a new message with updated values
		messageService.create(updateMessage);
		
		return updateMessage;
	}
	
	//Delete message by giving its title
	@DeleteMapping(value = "/{title}")
	public boolean delete(@PathVariable String title)
	{
		//Find the message that wanted to delete
		Message message = messageService.getByTitle(title);
		
		messageService.delete(message);
		return true;
	}
	

}
