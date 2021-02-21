package com.dlabs.cameldemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("project")
	private String project;
}
