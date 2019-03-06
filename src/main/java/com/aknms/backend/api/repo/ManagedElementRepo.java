package com.aknms.backend.api.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aknms.backend.api.model.ManagedElement;
import com.aknms.backend.api.model.User;

public interface ManagedElementRepo extends MongoRepository<ManagedElement, String> {
	
	List<ManagedElement> findByIpAddress(String ipAddress);


}
