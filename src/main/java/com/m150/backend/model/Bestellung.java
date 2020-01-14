package com.m150.backend.model;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

public class Bestellung {
	@ApiModelProperty(notes = "Orderd Chips", name = "All Chips", required = true, value = "test chips")
	private String chips;
	@ApiModelProperty(notes = "Description of the Chips", name = "desc", required = true, value = "test description")
	private double total;

	public Bestellung() {
		
	}
	
	public Bestellung(String chips, double total) {
		super();
		this.chips = chips;
		this.total = total;
	}

	public String getChips() {
		return chips;
	}

	public double getTotal() {
		return total;
	}
}
