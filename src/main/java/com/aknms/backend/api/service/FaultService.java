package com.aknms.backend.api.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aknms.backend.api.Faults;
import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventType;
import com.aknms.backend.api.model.EventTypeCount;
import com.aknms.backend.api.repo.EventRepo;


@Service
public class FaultService implements Faults {

	@Autowired
	private EventRepo eventRepo;
	

	@Override
	public Event getEventById(long id) {
		Event event  = eventRepo.findById(id);
		return event;
	}

	@Override
	public Iterable<Event> getAllEvents() {
		Iterable<Event> events = eventRepo.findAll();
		return events;
	}
	
	@Override
	public List<EventTypeCount> getEventCount() {
		List<EventTypeCount> eventTypeCounts = eventRepo.countByEventType();
		// Commenting creation of Total Events Count as react-minimal-pie doesn't need it
		/*
		Long count = eventRepo.count();
		eventTypeCounts.add(new EventTypeCount(count));
		*/
		return eventTypeCounts;
		
	}

	
	@Override
	public List<Event> getEventsLastSince(int lastSinceInMinutes) {
		System.out.println(Calendar.getInstance().getTimeInMillis());
		List<Event> events = eventRepo.findByLastUpdatedInDate(Calendar.getInstance().getTimeInMillis() - lastSinceInMinutes*60*1000);
		return events;
	}

	@Override
	public List<Event> getEventsByDeviceIP(String ipAddress) throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getByName(ipAddress);
		
	    List<Event> events = eventRepo.findAllByIpAddress(ipAddress);
		return events;
	}

	@Override
	public List<Event> getEventByType(String eventType) {
		
		List<Event> events = eventRepo.findByType(EventType.valueOf(eventType));
		
		return events;
	}

	@Override
	public List<Event> getNEventsFromRecordId(Integer fromRecordId, Integer recordCount) {
		List<Event> events = eventRepo.findNEventsFromId(fromRecordId, recordCount);
		return events;
	}
	

}
