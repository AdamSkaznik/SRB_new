/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.PatrolComposition;
import com.airportspolish.SRB.repository.PatrolCompositionRepository;
import com.airportspolish.SRB.service.PatrolCompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrolCompositionImpl implements PatrolCompositionService {
    @Autowired
    PatrolCompositionRepository patrolCompositionRepository;

    public PatrolCompositionImpl(PatrolCompositionRepository patrolCompositionRepository) {
        this.patrolCompositionRepository = patrolCompositionRepository;
    }

    @Override
    public List<PatrolComposition> getAll() {
        return patrolCompositionRepository.findAll();
    }

    @Override
    public PatrolComposition getById(Long id) {
        return patrolCompositionRepository.getReferenceById(id);
    }

    @Override
    public void save(PatrolComposition patrolComposition) {
        patrolCompositionRepository.save(patrolComposition);
    }
}
