package com.cmad1.fault.model.repo;

import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.model.User;

public interface UserRepo extends CrudRepository <User, Integer>{

}
