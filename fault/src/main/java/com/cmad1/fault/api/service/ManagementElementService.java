package com.cmad1.fault.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmad1.fault.api.ManagedElements;
import com.cmad1.fault.api.repo.ManagedElementRepo;

@Service
public class ManagementElementService implements ManagedElements {

	@Autowired
	private ManagedElementRepo managedElementRepo;

}
