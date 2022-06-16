package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.EventDto;
import com.hit.hitproduct.domains.entities.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<Event> getEvents();

    Event getEventById(Long id);

    Event createEvent(EventDto eventDto);

    Event updateEvent(Long id, EventDto eventDto);

    TrueFalseResponse deleteEvent(Long id);
}
