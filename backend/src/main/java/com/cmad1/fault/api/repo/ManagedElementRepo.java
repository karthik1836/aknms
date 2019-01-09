package com.cmad1.fault.api.repo;

import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.api.model.ManagedElement;

public interface ManagedElementRepo extends CrudRepository<ManagedElement, Integer> {

}
