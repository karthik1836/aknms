package com.aknms.backend.api.rest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aknms.backend.api.Faults;
import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventTypeCount;

@RestController
public class FaultRootCntrl {

	@Autowired
	private Faults faults;
	
	
	@RequestMapping(value = "/event/count", method = RequestMethod.GET)
	public ResponseEntity<List<EventTypeCount>> getEventsCount()  {
		List<EventTypeCount> eventCount = faults.getEventCount();
		return new ResponseEntity<List<EventTypeCount>>(eventCount, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEventById(@PathVariable int id){
		Event event = faults.getEventById(id);
		return new ResponseEntity<Event>(event, HttpStatus.OK);		
	}
	
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Event>> getEvent (@RequestParam(value="type") Optional<String> eventType, @RequestParam(value="eventsLastSince") Optional<Integer> eventsLastSince,
			@RequestParam(value="source") Optional<String> source) throws UnknownHostException {
		Iterable<Event> event = null;
		if(eventType.isPresent()) {
			event = faults.getEventByType(eventType.get().toUpperCase().trim());
		} else if (eventsLastSince.isPresent()) {
			event = faults.getEventsLastSince(eventsLastSince.get());
		} else if (source.isPresent()) {
			event = faults.getEventsByDeviceIP(source.get());
		} else {
			event = faults.getAllEvents();
		}
		return new ResponseEntity<Iterable<Event>>(event, HttpStatus.OK);
		
	}
	
	

}
