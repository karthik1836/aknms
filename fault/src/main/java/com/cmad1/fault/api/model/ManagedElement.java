package com.cmad1.fault.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ManagedElement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private long id;
	
	@NotNull
	@Column(length=15)
	private String ipAddress;
	
	@NotNull 
	private boolean communicationState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
