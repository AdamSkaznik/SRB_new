/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.History;

import java.util.List;

public interface HistoryService {
    List<History> getAll();
    void saveHistory(History history);
    History getById(Long id);
    List<History> getByEventId(Long eventId);

}
