package com.aknms.backend.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aknms.backend.api.Users;
import com.aknms.backend.api.model.User;

@RestController
@CrossOrigin
public class UsersRootCntrl {

	@Autowired
	private Users usersService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = usersService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable String name) {
		User user = usersService.getUser(name);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder builder) {
		usersService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user, UriComponentsBuilder builder) {
		usersService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<User> removeUser(@PathVariable String name) {
		usersService.removeUser(name);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
