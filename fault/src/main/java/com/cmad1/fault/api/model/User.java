package com.cmad1.fault.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@NotNull
	private EventType userName;
	
	@NotNull
	@JsonProperty(access = Access.WRITE_ONLY)
	private EventType password;
	
	@NotNull
	@ManyToOne
	@JsonIgnore
	private UserGroup userGroup;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EventType getUserName() {
		return userName;
	}
	public void setUserName(EventType userName) {
		this.userName = userName;
	}
	@JsonIgnore
	public EventType getPassword() {
		return password;
	}
	public void setPassword(EventType password) {
		this.password = password;
	}
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	

}
