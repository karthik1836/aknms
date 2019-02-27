package com.aknms.backend.api;

import java.util.List;

import com.aknms.backend.api.model.User;
import com.aknms.backend.api.model.UserGroup;

public interface Users {

	public void addUser(User User);

	public void addUserGroup(UserGroup userGroup);

	public void removeUser(User user);

	public void removeUserGroup(UserGroup userGroup);

	public User getUser(int id);

	public User getUserBy(String name);

	public UserGroup getUserGroup(int id);

	public List<User> getUsers();

	public List<User> getUsersinGroup(UserGroup userGroup);

}
