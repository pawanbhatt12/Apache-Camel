package com.dlabs.cameldemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyDemoActiveMQRouter extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		
		//from("activemq:active-mq-timer?period=1000") // timer generates message at every time
		//.transform().constant("Actve MQ queue ") // transform the input message
		//.to("activemq:my-activemq-queue"); // save or log the data
	}

}
