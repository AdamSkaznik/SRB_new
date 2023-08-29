/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.History;
import com.airportspolish.SRB.repository.HistoryRepository;
import com.airportspolish.SRB.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAll() {
        return historyRepository.findAll();
    }

    @Override
    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    @Override
    public History getById(Long id) {
        return historyRepository.getReferenceById(id);
    }

    @Override
    public List<History> getByEventId(Long eventId) {
        return historyRepository.getAllByEventId(eventId);
    }
}
