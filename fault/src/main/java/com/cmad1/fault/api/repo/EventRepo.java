package com.cmad1.fault.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.api.model.Event;

public interface EventRepo extends CrudRepository<Event, Integer> {

	
}
