package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Messages;
import com.infosys.repositories.MessagesRepository;

@Service
public class MessagesServices implements MessagesServiceInterface {
	
	@Autowired
	public MessagesRepository messagesRepository;
	
	public void addMessage(Messages message) {
		messagesRepository.save(message);
	}
	
	public List<Messages> getInboxMessages(String roleId){
		return messagesRepository.getInboxMessages(roleId);
	}
	
	public List<Messages> getOutboxMessages(String roleId){
		return messagesRepository.getOutboxMessages(roleId);
	}
}
