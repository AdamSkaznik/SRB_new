/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Event;
import com.airportspolish.SRB.repository.EventRepository;
import com.airportspolish.SRB.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

//    private static final Logger logger =
    @Autowired
    EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event getById(Long id) {
        return eventRepository.getReferenceById(id);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event getLast(String year) {
        return eventRepository.getLast(year);
    }

    @Override
    public void updatePatrol(Long patrolId, Integer eventStatusId, Long id) {
        eventRepository.updatePatrol(patrolId, eventStatusId, id);
    }

    @Override
    public void updateWork(Long id) {
        eventRepository.updateWork(id);
    }

//    @Override
//    public void deleteEvent(Long id) {
//        eventRepository.delete(id);
//    }
}
