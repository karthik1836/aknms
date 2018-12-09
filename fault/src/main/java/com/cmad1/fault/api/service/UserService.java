package com.cmad1.fault.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmad1.fault.api.Users;
import com.cmad1.fault.api.repo.UserRepo;

@Service
public class UserService implements Users {

	@Autowired
	private UserRepo userRepo;

}
