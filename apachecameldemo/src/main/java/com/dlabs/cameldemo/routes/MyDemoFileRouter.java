package com.dlabs.cameldemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyDemoFileRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:C:\\Users\\pbhatt\\git\\git\\git\\Apache Camel Demo\\apachecameldemo\\src\\main\\resources\\input")
		.to("file:C:\\Users\\pbhatt\\git\\git\\git\\Apache Camel Demo\\apachecameldemo\\src\\main\\resources\\output");
	}

}
