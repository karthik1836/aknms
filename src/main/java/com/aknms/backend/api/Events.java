package com.aknms.backend.api;

import java.net.UnknownHostException;
import java.util.List;

import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventTypeCount;

public interface Events {

	public List<EventTypeCount> getEventCount();

	public Event getEventById(long id);

	public Iterable<Event> getAllEvents();

	public List<Event> getEventsByDeviceIP(String ipAddress, Integer fromRecordId, Integer recordCount, String column,
			String direction) throws UnknownHostException;

	/*
	 * for Later use public List<Event> getEventByDeviceId(long deviceId);
	 */

	public List<Event> getEventByType(String eventType, Integer fromRecordId, Integer recordCount, String column,
			String direction);

	public List<Event> getEventsLastSince(int lastSinceInMinutes, Integer fromRecordId, Integer recordCount,
			String column, String direction);

	public List<Event> getNEventsFromRecordId(Integer fromRecordId, Integer recordCount, String column,
			String direction);

}
