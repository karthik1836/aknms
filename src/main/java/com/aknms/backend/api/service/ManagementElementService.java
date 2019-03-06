package com.aknms.backend.api.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aknms.backend.api.ManagedElements;
import com.aknms.backend.api.exception.ManagedElementAlreadyExistsException;
import com.aknms.backend.api.exception.ManagedElementNotFoundException;
import com.aknms.backend.api.exception.UserNotFoundException;
import com.aknms.backend.api.model.ManagedElement;
import com.aknms.backend.api.repo.ManagedElementRepo;
import com.aknms.backend.api.repo.UserRepo;

@Service
public class ManagementElementService implements ManagedElements {

	@Autowired
	private ManagedElementRepo managedElementRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public void addManagedElement(ManagedElement managedElement) throws ManagedElementAlreadyExistsException {
		try {
			ManagedElement managedElementTmp = getManagedElement(managedElement.getIpAddress());
			if (managedElementTmp != null) {
				throw new ManagedElementAlreadyExistsException(
						"ManagedElement with ipAddress " + managedElement.getIpAddress() + " already exists");
			}
		} catch (ManagedElementNotFoundException ex) {
			managedElementRepo.save(managedElement);
		}
	}

	@Override
	public void removeManagedElement(String ipAddress) {
		// TODO Auto-generated method stub
	}

	@Override
	public ManagedElement getManagedElement(String ipAddress) {
		List<ManagedElement> managedElements = managedElementRepo.findByIpAddress(ipAddress);
		if (CollectionUtils.isEmpty(managedElements)) {
			throw new ManagedElementNotFoundException("ManagedElement with ipAdress " + ipAddress + " does not exist");
		}
		return managedElements.get(0);
	}

	@Override
	public List<ManagedElement> getManagedElements() {
		return managedElementRepo.findAll();
	}

}
