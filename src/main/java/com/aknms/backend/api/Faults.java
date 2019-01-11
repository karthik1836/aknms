package com.aknms.backend.api;

import java.net.UnknownHostException;
import java.util.List;

import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventTypeCount;

public interface Faults {
	
	
	public List<EventTypeCount> getEventCount();
	
	public Event getEventById(long id);
	
	public Iterable<Event> getAllEvents();
	
	public List<Event> getEventsByDeviceIP(String ipAddress) throws UnknownHostException;
	
	/* for Later use
	public List<Event> getEventByDeviceId(long deviceId);
	*/
	
	public List<Event> getEventByType(String eventType);
	
	public List<Event> getEventsLastSince(int lastSinceInMinutes);
	
	

}
