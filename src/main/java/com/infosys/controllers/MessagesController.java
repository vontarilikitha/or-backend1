package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Messages;
import com.infosys.services.MessagesServices;

@RestController
@CrossOrigin("http://localhost:4200")
public class MessagesController {

	@Autowired
	MessagesServices messagesService;
	
	@PostMapping("/addMessage")
	public void addMessage(@RequestBody Messages messages) {
		System.out.println(messages);
		messagesService.addMessage(messages);
	}
	
	@GetMapping("/getInboxMessagesByRoleId/{roleId}")
	public List<Messages> getInboxMessages(@PathVariable String roleId){
		return messagesService.getInboxMessages(roleId);
	}
	
	@GetMapping("/getOutboxMessagesByRoleId/{roleId}")
	public List<Messages> getOutboxMessages(@PathVariable String roleId){
		return messagesService.getOutboxMessages(roleId);
	}
	
}
