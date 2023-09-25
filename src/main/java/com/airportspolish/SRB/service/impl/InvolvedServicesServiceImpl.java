/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.InvolvedServices;
import com.airportspolish.SRB.repository.InvolvedServicesRepository;
import com.airportspolish.SRB.service.InvolvedServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvolvedServicesServiceImpl implements InvolvedServicesService {
    @Autowired
    InvolvedServicesRepository involvedServicesRepository;

    public InvolvedServicesServiceImpl(InvolvedServicesRepository involvedServicesRepository) {
        this.involvedServicesRepository = involvedServicesRepository;
    }

    @Override
    public List<InvolvedServices> getAll() {
        return involvedServicesRepository.findAll();
    }

    @Override
    public InvolvedServices getById(Long id) {
        return involvedServicesRepository.getReferenceById(id);
    }

    @Override
    public InvolvedServices save(InvolvedServices involvedServices) {
        return involvedServicesRepository.save(involvedServices);
    }


}
