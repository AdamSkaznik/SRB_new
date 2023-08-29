/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.WayOfEnding;

import java.util.List;

public interface WayOfEndingService {
    List<WayOfEnding> getAll();
    WayOfEnding getById(Long id);
    void saveWayOdEnding(WayOfEnding wayOfEnding);
}
