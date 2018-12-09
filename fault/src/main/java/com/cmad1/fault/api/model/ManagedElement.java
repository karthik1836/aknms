package com.cmad1.fault.api.model;

import java.net.InetAddress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ManagedElement {

	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private long id;
	
	@NotNull
	private InetAddress ipAddress;
	
	@NotNull 
	private boolean communicationState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public InetAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(InetAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isCommunicationState() {
		return communicationState;
	}

	public void setCommunicationState(boolean communicationState) {
		this.communicationState = communicationState;
	}

}
