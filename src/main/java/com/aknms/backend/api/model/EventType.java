package com.aknms.backend.api.model;

public enum EventType {
	
	INFO("Green"), ERROR("Red"), WARNING("Orange"), NOTIFICATION("Blue");
	
	
	private String color;
	
	private EventType(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

}