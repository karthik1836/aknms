package com.cmad1.fault.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.api.model.User;

public interface UserRepo extends CrudRepository <User, Integer>{

}
