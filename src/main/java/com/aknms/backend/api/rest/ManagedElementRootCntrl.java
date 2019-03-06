package com.aknms.backend.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aknms.backend.api.ManagedElements;
import com.aknms.backend.api.model.ManagedElement;
import com.aknms.backend.api.model.User;

@RestController
@CrossOrigin
public class ManagedElementRootCntrl {

	@Autowired
	private ManagedElements managedElementService;

	@RequestMapping(value = "/managedElement", method = RequestMethod.GET)
	public ResponseEntity<List<ManagedElement>> getManagedElements() {
		List<ManagedElement> managedElements = managedElementService.getManagedElements();
		return new ResponseEntity<List<ManagedElement>>(managedElements, HttpStatus.OK);
	}

	@RequestMapping(value = "/managedElement/{ipAddress}", method = RequestMethod.GET)
	public ResponseEntity<ManagedElement> getMangedElementByIp(@PathVariable String ipAddress) {
		ManagedElement managedElement = managedElementService.getManagedElement(ipAddress);
		return new ResponseEntity<ManagedElement>(managedElement, HttpStatus.OK);
	}

	@RequestMapping(value = "/managedElement", method = RequestMethod.POST)
	public ResponseEntity<ManagedElement> addManagedElement(@RequestBody ManagedElement managedElement,
			UriComponentsBuilder builder) {
		managedElementService.addManagedElement(managedElement);
		return new ResponseEntity<ManagedElement>(managedElement, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/managedElement/{ipAddress}", method = RequestMethod.DELETE)
	public ResponseEntity<User> removeManagedElement(@PathVariable String ipAddress) {
		managedElementService.removeManagedElement(ipAddress);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
