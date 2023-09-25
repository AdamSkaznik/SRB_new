/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.WayOfEnding;
import com.airportspolish.SRB.repository.WayOfEndingRepository;
import com.airportspolish.SRB.service.WayOfEndingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WayOfEndingServiceImpl implements WayOfEndingService {

    @Autowired
    WayOfEndingRepository wayOfEndingRepository;

    public WayOfEndingServiceImpl(WayOfEndingRepository wayOfEndingRepository) {
        this.wayOfEndingRepository = wayOfEndingRepository;
    }

    @Override
    public List<WayOfEnding> getAll() {
        return wayOfEndingRepository.findAll();
    }

    @Override
    public WayOfEnding getById(Long id) {
        return wayOfEndingRepository.getReferenceById(id);
    }

    @Override
    public WayOfEnding saveWayOdEnding(WayOfEnding wayOfEnding) {
        return wayOfEndingRepository.save(wayOfEnding);
    }
}
