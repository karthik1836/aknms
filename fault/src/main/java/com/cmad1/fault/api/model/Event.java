package com.cmad1.fault.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private long id;
	
	@NotNull
	private long timestamp;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="source", referencedColumnName="ipAddress")
	private ManagedElement managedElement;
	
	@Column(length=1024)
	private String message;
	
	@NotNull 
	@Column(length=20)
    @Enumerated(EnumType.STRING)
	private EventType type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public ManagedElement getManagedElement() {
		return managedElement;
	}

	public void setManagedElement(ManagedElement managedElement) {
		this.managedElement = managedElement;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
