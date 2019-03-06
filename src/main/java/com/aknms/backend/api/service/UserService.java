package com.aknms.backend.api.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aknms.backend.api.Users;
import com.aknms.backend.api.exception.UserAlreadyExistsException;
import com.aknms.backend.api.exception.UserNotFoundException;
import com.aknms.backend.api.model.User;
import com.aknms.backend.api.model.UserGroup;
import com.aknms.backend.api.repo.UserRepo;

@Service
public class UserService implements Users {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User getUser(String name) throws UserNotFoundException {
		List<User> users = userRepo.findByUsername(name);
		if (CollectionUtils.isEmpty(users)) {
			throw new UserNotFoundException("User with name " + name + " does not exist");
		}
		return users.get(0);
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public void addUser(User user) throws UserAlreadyExistsException {
		try {
			User userTmp = getUser(user.getUsername());
			if (userTmp != null) {
				throw new UserAlreadyExistsException("User with name " + user.getUsername() + " already exists");
			}
		} catch (UserNotFoundException ex) {
			userRepo.save(user);
		}
	}

	@Override
	public void removeUser(String username) throws UserNotFoundException {
		getUser(username);
		userRepo.deleteUserByUsername(username);
	}

	@Override
	public void updateUser(User user) throws UserNotFoundException {
		removeUser(user.getUsername());
		userRepo.save(user);
	}

	@Override
	public void addUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserGroup getUserGroup(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersinGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
