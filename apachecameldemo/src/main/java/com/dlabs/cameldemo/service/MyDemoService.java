package com.dlabs.cameldemo.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.dlabs.cameldemo.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyDemoService implements Processor{

	static User user;
	
	public String message() {
		
		log.debug("Inside MyDemoService");
		return "Inside MyDemoService";
	}
	
	public User getUser() {
		
		log.debug("Getting User {}", user);
		return user;
		
	}
	
	public void logUser(User user) {
		
		MyDemoService.user = user;
		log.debug("Logging User {}", user);
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		MyDemoService.user = (User) exchange.getIn().getBody();
		log.debug("Logging User {}", user);
	}
}
