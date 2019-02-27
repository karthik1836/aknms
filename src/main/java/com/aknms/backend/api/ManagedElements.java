package com.aknms.backend.api;

import java.util.List;

import com.aknms.backend.api.model.ManagedElement;
import com.aknms.backend.api.model.User;

public interface ManagedElements {

	public void addManagedElement(ManagedElement managedElement);

	public void removeManagedElement(int meId);

	public User getManagedElement(int id);

	public List<User> getManagedElement();

}
