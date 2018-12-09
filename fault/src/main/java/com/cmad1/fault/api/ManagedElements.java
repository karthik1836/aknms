package com.cmad1.fault.api;

import java.util.List;

import com.cmad1.fault.api.model.ManagedElement;
import com.cmad1.fault.api.model.User;

public interface ManagedElements {
	
	

	
	public void addManagedElement(ManagedElement managedElement);
	
	public void removeManagedElement(int meId);
	
	public User getManagedElement(int id);
	
	public List<User> getManagedElement();
	

}
