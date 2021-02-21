package com.dlabs.cameldemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlabs.cameldemo.service.MyDemoService;

@Component
public class MyDemoTimeRouter extends RouteBuilder{

	@Autowired
	MyDemoService myDemoServiceProcessor;
	
	@Override
	public void configure() throws Exception {
		
		from("timer:first-timer") // timer generates message at every time
		.bean(myDemoServiceProcessor, "message") // invoke service
		//.transform().constant("Hello transform at " + LocalDateTime.now()) // transform the input message
		.to("log:first-timer"); // save or log the data
	}

}
