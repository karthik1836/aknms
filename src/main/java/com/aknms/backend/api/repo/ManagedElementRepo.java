package com.aknms.backend.api.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aknms.backend.api.model.ManagedElement;

public interface ManagedElementRepo extends MongoRepository<ManagedElement, Integer> {

}
