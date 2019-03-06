package com.aknms.backend.api.model;

import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Document(collection = "user")
public class User {

	/*
	 * @GeneratedValue(strategy = GenerationType.TABLE) private int id;
	 */

	@Id
	@NotNull
	private String username;

	private List<ManagedElement> managedElements;

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
	public List<ManagedElement> getManagedElements() {
		return managedElements;
	}

	public void setManagedElements(List<ManagedElement> managedElements) {
		this.managedElements = managedElements;
	}

	/*
	 * @NotNull
	 * 
	 * @JsonProperty(access = Access.WRITE_ONLY) private String password;
	 * 
	 * @ManyToOne
	 * 
	 * @JsonIgnore private UserGroup userGroup;
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * 
	 * @JsonIgnore public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * public UserGroup getUserGroup() { return userGroup; }
	 * 
	 * public void setUserGroup(UserGroup userGroup) { this.userGroup = userGroup; }
	 */
	
	
	
	public User(String username, List<ManagedElement> managedElements) {
		this.username = username;
		this.setManagedElements(managedElements);
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}
