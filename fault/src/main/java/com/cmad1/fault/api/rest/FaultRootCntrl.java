package com.cmad1.fault.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmad1.fault.api.Faults;

@RestController
public class FaultRootCntrl {

	@Autowired
	private Faults faults;

}
