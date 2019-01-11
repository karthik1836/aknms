package com.aknms.backend.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.aknms.backend.api.model.User;

public interface UserRepo extends CrudRepository <User, Integer>{

}
