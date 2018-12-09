package com.cmad1.fault.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserGroup {

	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private int id;
	
	@NotNull
	private String groupName;
	
	@NotNull
	private UserPrivilege privilege;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public UserPrivilege getPriveledge() {
		return privilege;
	}

	public void setPriveledge(UserPrivilege privilege) {
		this.privilege = privilege;
	}

}
