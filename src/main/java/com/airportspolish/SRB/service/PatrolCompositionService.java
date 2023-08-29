/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.PatrolComposition;

import java.util.List;

public interface PatrolCompositionService {

    List<PatrolComposition> getAll();
    PatrolComposition getById(Long id);
    void save(PatrolComposition patrolComposition);
}
