package com.aknms.backend.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventType;
import com.aknms.backend.api.model.EventTypeCount;

public interface EventRepo extends CrudRepository<Event, Integer> {

	Event findById(long id);

	@Query("SELECT new com.aknms.backend.api.model.EventTypeCount(e.type, COUNT(*)) FROM  Event e GROUP BY e.type")
	List<EventTypeCount> countByEventType();

	@Query("Select e from Event e where e.timestamp > ?1")
	List<Event> findByLastUpdatedInDate(long timestampSince);

	List<Event> findAllByIpAddress(String ipAddress);

	List<Event> findByType(EventType type);

	@Query(nativeQuery = true, value = "SELECT * from event where id >= ?1 ORDER BY id LIMIT ?2")
	List<Event> findNEventsFromId(Integer idFrom, Integer recordCount);

}
