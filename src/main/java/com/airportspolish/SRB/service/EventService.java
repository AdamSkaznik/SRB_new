/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event getById(Long id);
    Event saveEvent(Event event);
    Event getLast(String year);
    void updatePatrol(Long patrolId, Integer eventStatusId, Long id);
    void updateWork(Long id);
//    void deleteEvent(Long id);
}
