package com.cmad1.fault.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmad1.fault.api.Faults;
import com.cmad1.fault.api.model.Event;

@RestController
public class FaultRootCntrl {

	@Autowired
	private Faults faults;
	
	
	
	
	
	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable int id)  {
		Event event = faults.getEventById(id);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
		
	}
	
	
	

}
