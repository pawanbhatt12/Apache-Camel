package com.dlabs.cameldemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.dlabs.cameldemo.model.User;
import com.dlabs.cameldemo.service.MyDemoService;

@Component
public class MyDemoRestRouter extends RouteBuilder{

	@Autowired
	MyDemoService myDemoServiceProcessor;
	
	@Override
	public void configure() throws Exception {
	 
		restConfiguration()
		.component("servlet")
		.host("localhost")
		.bindingMode(RestBindingMode.json);

		rest()
		.get("/hello")
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.route()
		.setBody(constant("My Demo Camel router"))
		.endRest();

		rest()
		.get("/getUser")
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.route()
		.setBody(() -> myDemoServiceProcessor.getUser())
		.endRest();

		rest()
		.post("/saveUser")
		.consumes(MediaType.APPLICATION_JSON_VALUE)
		.type(User.class)
		.outType(User.class)
		.route()
		.process(myDemoServiceProcessor)
		.endRest();
		
		from("rest:get:demo2/{me}")
		  .to("rest:get:hello/{me}");
	}

}
