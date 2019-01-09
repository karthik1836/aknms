package com.cmad1.fault.api;

import java.util.List;

import com.cmad1.fault.api.model.User;
import com.cmad1.fault.api.model.UserGroup;

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
