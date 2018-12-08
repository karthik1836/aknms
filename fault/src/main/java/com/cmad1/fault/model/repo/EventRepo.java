package com.cmad1.fault.model.repo;

import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.model.Event;

public interface EventRepo extends CrudRepository<Event, Integer> {

	
}
