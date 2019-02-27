package com.aknms.backend.api.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aknms.backend.api.model.User;

public interface UserRepo extends MongoRepository <User, Integer>{

}
