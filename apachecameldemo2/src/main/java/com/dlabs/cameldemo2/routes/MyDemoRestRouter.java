package com.dlabs.cameldemo2.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MyDemoRestRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	 
		restConfiguration()
		.component("servlet")
		.host("localhost")
		.bindingMode(RestBindingMode.json);

		rest()
		.get("/demo2")
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.route()
		.setBody(constant("My Demo Camel router demo2"))
		.endRest();

	}

}
