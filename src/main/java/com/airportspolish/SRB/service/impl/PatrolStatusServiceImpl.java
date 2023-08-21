/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.PatrolStatus;
import com.airportspolish.SRB.repository.PatrolStatusRepository;
import com.airportspolish.SRB.service.PatrolStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrolStatusServiceImpl implements PatrolStatusService {
    @Autowired
    PatrolStatusRepository patrolStatusRepository;

    public PatrolStatusServiceImpl(PatrolStatusRepository patrolStatusRepository) {
        this.patrolStatusRepository = patrolStatusRepository;
    }

    @Override
    public List<PatrolStatus> getAll() {
        return patrolStatusRepository.findAll();
    }

    @Override
    public PatrolStatus getById(Long id) {
        return patrolStatusRepository.getReferenceById(id);
    }

    @Override
    public PatrolStatus savePatrolStatus(PatrolStatus patrolStatus) {
        patrolStatusRepository.save(patrolStatus);
        return patrolStatus;
    }
}
