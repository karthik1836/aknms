package com.cmad1.fault.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmad1.fault.api.ManagedElements;
import com.cmad1.fault.api.model.ManagedElement;
import com.cmad1.fault.api.model.User;
import com.cmad1.fault.api.repo.ManagedElementRepo;

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
