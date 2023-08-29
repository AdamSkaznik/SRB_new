/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.EventStatus;
import com.airportspolish.SRB.repository.EventStatusRepository;
import com.airportspolish.SRB.service.EventStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventStatusServiceImpl implements EventStatusService {
    @Autowired
    EventStatusRepository eventStatusRepository;

    public EventStatusServiceImpl(EventStatusRepository eventStatusRepository) {
        this.eventStatusRepository = eventStatusRepository;
    }

    @Override
    public List<EventStatus> getAll() {
        return eventStatusRepository.findAll();
    }

    @Override
    public EventStatus saveStatusEvent(EventStatus eventStatus) {
        eventStatusRepository.save(eventStatus);
        return eventStatus;
    }

    @Override
    public EventStatus getById(int id) {
        return eventStatusRepository.getReferenceById(id);
    }
}
