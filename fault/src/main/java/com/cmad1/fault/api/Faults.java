package com.cmad1.fault.api;

import java.net.InetAddress;
import java.util.List;

import com.cmad1.fault.api.model.Event;
import com.cmad1.fault.api.model.EventType;

public interface Faults {
	
	
	public Event getEventById(long id);
	
	public List<Event> getAllEvents();
	
	public List<Event> getEventsByDeviceIP(InetAddress inetAddress);
	
	public List<Event> getEventByDeviceId(long deviceId);
	
	public List<Event> getEventByType(EventType eventType);
	
	public List<Event> getEventInLast24();
	
	

}
