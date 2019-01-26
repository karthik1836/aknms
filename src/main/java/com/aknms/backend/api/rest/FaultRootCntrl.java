package com.aknms.backend.api.rest;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

	private static String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

	@Autowired
	private Faults faults;

	@RequestMapping(value = "/event/count", method = RequestMethod.GET)
	public ResponseEntity<List<EventTypeCount>> getEventsCount() {
		List<EventTypeCount> eventCount = faults.getEventCount();
		HttpHeaders headers = new HttpHeaders();
		headers.add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return new ResponseEntity<List<EventTypeCount>>(eventCount, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEventById(@PathVariable int id) {
		Event event = faults.getEventById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return new ResponseEntity<Event>(event, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Event>> getEvent(@RequestParam(value = "type") Optional<String> eventType,
			@RequestParam(value = "eventsLastSince") Optional<Integer> eventsLastSince,
			@RequestParam(value = "source") Optional<String> source,
			@RequestParam(value = "id-from") Optional<Integer> idFrom,
			@RequestParam(value = "count", defaultValue = "50") Optional<Integer> recordCount)
			throws UnknownHostException {
		Iterable<Event> event = null;
		if (eventType.isPresent()) {
			event = faults.getEventByType(eventType.get().toUpperCase().trim());
		} else if (eventsLastSince.isPresent()) {
			event = faults.getEventsLastSince(eventsLastSince.get());
		} else if (source.isPresent()) {
			event = faults.getEventsByDeviceIP(source.get());
		} else if (idFrom.isPresent() && recordCount.isPresent()) {
			event = faults.getNEventsFromRecordId(idFrom.get(), recordCount.get());
		} else {
			event = faults.getAllEvents();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return new ResponseEntity<Iterable<Event>>(event, headers, HttpStatus.OK);

	}

}
