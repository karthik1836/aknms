package com.aknms.backend.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.aknms.backend.api.model.ManagedElement;

public interface ManagedElementRepo extends CrudRepository<ManagedElement, Integer> {

}
