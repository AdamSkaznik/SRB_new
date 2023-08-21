/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.EventType;

import java.util.List;

public interface EventTypeService {
    List<EventType> getAll();
    List<EventType> getAllActive();
    List<EventType> searchAllActive(String eventTypeName);
    EventType saveEventType(EventType eventType);
    EventType getById(Long eventTypeId);
}
