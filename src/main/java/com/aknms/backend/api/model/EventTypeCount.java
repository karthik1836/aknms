package com.aknms.backend.api.model;

import java.io.Serializable;

public class EventTypeCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private long value;
	private String color;
	
	
	public EventTypeCount(EventType eventType, Long count) {
		this.title = eventType.name();
		this.color = eventType.getColor();
		this.value = count;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	


}
