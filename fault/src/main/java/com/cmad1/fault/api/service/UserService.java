package com.cmad1.fault.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmad1.fault.api.Users;
import com.cmad1.fault.api.model.User;
import com.cmad1.fault.api.model.UserGroup;
import com.cmad1.fault.api.repo.UserRepo;

@Service
public class UserService implements Users {

	@Autowired
	private UserRepo userRepo;

	@Override
	public void addUser(User User) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserGroup getUserGroup(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersinGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
