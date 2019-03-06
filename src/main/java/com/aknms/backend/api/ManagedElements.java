package com.aknms.backend.api;

import java.util.List;

import com.aknms.backend.api.model.ManagedElement;

public interface ManagedElements {

	public void addManagedElement(ManagedElement managedElement);

	public void removeManagedElement(String ipAddress);

	public ManagedElement getManagedElement(String ipAddress);

	public List<ManagedElement> getManagedElements();

}
