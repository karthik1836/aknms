package com.aknms.backend.api.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aknms.backend.api.model.Event;
import com.aknms.backend.api.model.EventType;
import com.aknms.backend.api.model.EventTypeCount;

public interface EventRepo extends CrudRepository<Event, Integer> {

	Event findById(long id);

	@Query("SELECT new com.aknms.backend.api.model.EventTypeCount(e.type, COUNT(*)) FROM  Event e GROUP BY e.type")
	List<EventTypeCount> countByEventType();

	@Query("SELECT new com.aknms.backend.api.model.EventTypeCount(e.type, COUNT(*)) FROM  Event e WHERE ipAddress IN :ips GROUP BY e.type")
	List<EventTypeCount> countByEventTypeFilterIp(@Param("ips") List<String> ipAddressList);
	
	List<Event> findByIpAddressIn(List<String> ipAddressList);

	@Query("Select e from Event e where e.timestamp > ?1")
	List<Event> findByLastUpdatedInDate(long timestampSince, Pageable pageable);

	List<Event> findAllByIpAddress(String ipAddress, Pageable pageable);

	List<Event> findByIpAddressIn(List<String> ipAddressList, Pageable pageable);

	List<Event> findByType(EventType type, Pageable pageable);

	@Query("SELECT e from Event e")
	List<Event> findNEventsFromId(Pageable pageable);

}
