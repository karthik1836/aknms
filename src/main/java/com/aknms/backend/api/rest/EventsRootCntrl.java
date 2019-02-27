package com.aknms.backend.api.rest;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aknms.backend.api.Events;
import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventTypeCount;

@RestController
@CrossOrigin
public class EventsRootCntrl {

	@Autowired
	private Events events;

	@RequestMapping(value = "/event/count", method = RequestMethod.GET)
	public ResponseEntity<List<EventTypeCount>> getEventsCount() {
		List<EventTypeCount> eventCount = events.getEventCount();
		
		return new ResponseEntity<List<EventTypeCount>>(eventCount, HttpStatus.OK);

	}

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEventById(@PathVariable int id) {
		Event event = events.getEventById(id);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Event>> getEvent(@RequestParam(value = "type") Optional<String> eventType,
			@RequestParam(value = "eventsLastSince") Optional<Integer> eventsLastSince,
			@RequestParam(value = "source") Optional<String> source,
			@RequestParam(value = "id-from", defaultValue = "0" ) Optional<Integer> idFrom,
			@RequestParam(value = "sort_key", defaultValue = "id") Optional<String> column,
			@RequestParam(value = "sort_dir", defaultValue = "ASC") Optional<String> direction,
			@RequestParam(value = "count", defaultValue = "50") Optional<Integer> recordCount)
			throws UnknownHostException {
		Iterable<Event> event = null;
		if (eventType.isPresent()) {
			event = events.getEventByType(eventType.get().toUpperCase().trim(), idFrom.get(), recordCount.get(), column.get(), direction.get());
		} else if (eventsLastSince.isPresent()) {
			event = events.getEventsLastSince(eventsLastSince.get(), idFrom.get(), recordCount.get(), column.get(), direction.get());
		} else if (source.isPresent()) {
			event = events.getEventsByDeviceIP(source.get(), idFrom.get(), recordCount.get(), column.get(), direction.get());
		} else if (idFrom.isPresent() && recordCount.isPresent()) {
			event = events.getNEventsFromRecordId(idFrom.get(), recordCount.get(),  column.get(), direction.get());
		} else {
			event = events.getAllEvents();
		}
		return new ResponseEntity<Iterable<Event>>(event,  HttpStatus.OK);

	}

}
