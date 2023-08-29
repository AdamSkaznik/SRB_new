/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Zone;
import com.airportspolish.SRB.repository.ZoneRepository;
import com.airportspolish.SRB.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public List<Zone> getAll() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone getById(Long id) {
        return zoneRepository.getReferenceById(id);
    }

    @Override
    public Zone saveZone(Zone zone) {
        zoneRepository.save(zone);
        return zone;
    }

    @Override
    public List<Zone> getSearch(String zoneName) {
        return zoneRepository.getSearch(zoneName);
    }
}
