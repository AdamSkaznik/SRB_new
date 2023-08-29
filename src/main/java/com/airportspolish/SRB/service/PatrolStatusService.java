/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.PatrolStatus;

import java.util.List;

public interface PatrolStatusService {
    List<PatrolStatus> getAll();
    PatrolStatus getById(Long id);
    PatrolStatus savePatrolStatus(PatrolStatus patrolStatus);
}
