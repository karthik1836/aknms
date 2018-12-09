package com.cmad1.fault.api.service;

import java.net.InetAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmad1.fault.api.Faults;
import com.cmad1.fault.api.model.Event;
import com.cmad1.fault.api.model.EventType;
import com.cmad1.fault.api.repo.EventRepo;


@Service
public class FaultService implements Faults {

	@Autowired
	private EventRepo eventRepo;

	@Override
	public Event getEventById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByDeviceIP(InetAddress inetAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventByDeviceId(long deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventByType(EventType eventType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventInLast24() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
