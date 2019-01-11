package com.aknms.backend.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aknms.backend.api.ManagedElements;
import com.aknms.backend.api.model.ManagedElement;
import com.aknms.backend.api.model.User;
import com.aknms.backend.api.repo.ManagedElementRepo;

@Service
public class ManagementElementService implements ManagedElements {

	@Autowired
	private ManagedElementRepo managedElementRepo;

	@Override
	public void addManagedElement(ManagedElement managedElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeManagedElement(int meId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getManagedElement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getManagedElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
