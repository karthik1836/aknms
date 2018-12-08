package com.cmad1.fault.model.repo;

import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.model.ManagedElement;

public interface ManagedElementRepo extends CrudRepository<ManagedElement, Integer> {

}
