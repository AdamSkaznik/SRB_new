/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;


import com.airportspolish.SRB.model.EventStatus;

import java.util.List;

public interface EventStatusService {
    List<EventStatus> getAll();
    EventStatus saveStatusEvent(EventStatus eventStatus);
    EventStatus getById(int id);

}
