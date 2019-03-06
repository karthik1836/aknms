package com.aknms.backend.api.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aknms.backend.api.model.User;

public interface UserRepo extends MongoRepository<User, String> {

	List<User> findByUsername(String username);

	Long deleteUserByUsername(String username);

}
