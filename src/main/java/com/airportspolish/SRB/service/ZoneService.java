/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Zone;

import java.util.List;

public interface ZoneService {
    List<Zone> getAll();
    Zone getById(Long id);
    Zone saveZone(Zone zone);
    List<Zone> getSearch(String zoneName);
}
