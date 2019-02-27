package com.aknms.backend.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aknms.backend.api.Users;
import com.aknms.backend.api.model.User;
import com.aknms.backend.api.model.UserGroup;
import com.aknms.backend.api.repo.UserRepo;
import com.aknms.backend.api.exception.UserNotFoundException;

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
	public User getUser(int id) throws UserNotFoundException {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException());
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
