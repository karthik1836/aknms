package com.cmad1.fault.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cmad1.fault.api.model.Event;
import com.cmad1.fault.api.model.EventType;
import com.cmad1.fault.api.model.EventTypeCount;

public interface EventRepo extends CrudRepository<Event, Integer> {

	Event findById(long id);

	@Query("SELECT new com.cmad1.fault.api.model.EventTypeCount(e.type, COUNT(*)) FROM  Event e GROUP BY e.type")
	List<EventTypeCount> countByEventType();
	
	@Query("Select e from Event e where e.timestamp > ?1")
	List <Event> findByLastUpdatedInDate(long timestampSince);
	
	List<Event> findAllByManagedElementIpAddress(String source);

	List<Event> findByType(EventType type);	
	
}
