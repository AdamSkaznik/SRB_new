/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.EventType;
import com.airportspolish.SRB.repository.EventTypeReposioty;
import com.airportspolish.SRB.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {
    @Autowired
    EventTypeReposioty eventTypeReposioty;

    public EventTypeServiceImpl(EventTypeReposioty eventTypeReposioty) {
        this.eventTypeReposioty = eventTypeReposioty;
    }

    @Override
    public List<EventType> getAll() {
        return eventTypeReposioty.findAll();
    }

    @Override
    public List<EventType> getAllActive() {
        return eventTypeReposioty.getAllActive();
    }

    @Override
    public List<EventType> searchAllActive(String eventTypeName) {
        return eventTypeReposioty.searchEventType(eventTypeName);
    }

    @Override
    public EventType saveEventType(EventType eventType) {
        eventTypeReposioty.save(eventType);
        return eventType;
    }

    @Override
    public EventType getById(Long eventTypeId) {
        return eventTypeReposioty.getReferenceById(eventTypeId);
    }

}
