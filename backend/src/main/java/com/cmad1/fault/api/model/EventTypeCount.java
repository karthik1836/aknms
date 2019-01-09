package com.cmad1.fault.api.model;

import java.io.Serializable;

public class EventTypeCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String eventType;
	@SuppressWarnings("unused")
	private long count;
	
	private static String TOTAL = "TOTAL";

	
	public EventTypeCount(EventType eventType, Long count) {
		this.eventType = eventType.toString();
		this.count = count;
	}

	public EventTypeCount(Long count) {
		this.eventType = TOTAL;
		this.count = count;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}


	


}
