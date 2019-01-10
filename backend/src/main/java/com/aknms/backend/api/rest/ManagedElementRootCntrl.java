package com.aknms.backend.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aknms.backend.api.ManagedElements;

@RestController
public class ManagedElementRootCntrl {

	@Autowired
	private ManagedElements managedElements;
	

}
