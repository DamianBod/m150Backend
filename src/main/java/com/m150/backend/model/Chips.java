package com.m150.backend.model;

import io.swagger.annotations.ApiModelProperty;

public class Chips {
	@ApiModelProperty(notes = "Name of the Chips",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Description of the Chips",name="desc",required=true,value="test description")
	private String desc;
	@ApiModelProperty(notes = "Price of the Chips",name="price",required=true,value="test price")
	private double price;

	public Chips() {
		
	}
	
	public Chips(String name, String desc, double price) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
