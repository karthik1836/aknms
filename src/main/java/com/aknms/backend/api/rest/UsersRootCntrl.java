package com.aknms.backend.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aknms.backend.api.Users;
import com.aknms.backend.api.model.User;

@RestController
public class UsersRootCntrl {

	@Autowired
	private Users users;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = users.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
