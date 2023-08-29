/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Patrol;

import java.util.List;

public interface PatrolService {

    List<Patrol> getAll();
    Patrol getById(int id);
    Patrol savePatrol(Patrol patrol);
    List<Patrol> getByName(String patrolName);
}
