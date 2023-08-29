/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Patrol;
import com.airportspolish.SRB.repository.PatrolRepository;
import com.airportspolish.SRB.service.PatrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrolServiceImpl implements PatrolService {
    @Autowired
    PatrolRepository patrolRepository;

    public PatrolServiceImpl(PatrolRepository patrolRepository) {
        this.patrolRepository = patrolRepository;
    }

    @Override
    public List<Patrol> getAll() {
        return patrolRepository.findAll();
    }

    @Override
    public Patrol getById(int id) {
        return patrolRepository.getReferenceById(id);
    }

    @Override
    public Patrol savePatrol(Patrol patrol) {
        patrolRepository.save(patrol);
        return patrol;
    }

    @Override
    public List<Patrol> getByName(String patrolName) {
        return patrolRepository.getByName(patrolName);
    }
}
