package com.aknms.backend.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aknms.backend.api.Users;

@RestController
public class UsersRootCntrl {

	@Autowired
	private Users users;

}
