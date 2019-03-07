package com.aknms.backend.api;

import java.util.List;

import com.aknms.backend.api.model.User;
import com.aknms.backend.api.model.UserGroup;

public interface Users {

	public List<User> getUsers();

	public User getUser(String name);

	public void addUser(User user);

	public void updateUser(User user);

	public void removeUser(String username);
	
	public void addUserGroup(UserGroup userGroup);

	public void removeUserGroup(UserGroup userGroup);

	public UserGroup getUserGroup(int id);

	public List<User> getUsersinGroup(UserGroup userGroup);

}
