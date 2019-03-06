package com.aknms.backend.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "managedElement")
public class ManagedElement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private long id;
	*/
	
	@Id
	@Column(length=15)
	private String ipAddress;
	
	@JsonIgnore
	private boolean communicationState;

	/*
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	*/

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isCommunicationState() {
		return communicationState;
	}

	public void setCommunicationState(boolean communicationState) {
		this.communicationState = communicationState;
	}

}
