/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Spb;
import com.airportspolish.SRB.repository.SpbRepository;
import com.airportspolish.SRB.service.SpbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpbServiceImpl implements SpbService {
    @Autowired
    SpbRepository spbRepository;

    public SpbServiceImpl(SpbRepository spbRepository) {
        this.spbRepository = spbRepository;
    }

    @Override
    public List<Spb> getAll() {
        return spbRepository.findAll();
    }

    @Override
    public Spb getById(Long id) {
        return spbRepository.getReferenceById(id);
    }

    @Override
    public void save(Spb spb) {
        spbRepository.save(spb);
    }
}
