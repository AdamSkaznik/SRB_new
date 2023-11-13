/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.MedicalServices;
import com.airportspolish.SRB.repository.MedicalServicesRepository;
import com.airportspolish.SRB.service.MedicalServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServicesServiceImpl implements MedicalServicesService {
    @Autowired
    MedicalServicesRepository medicalServicesRepository;

    public MedicalServicesServiceImpl(MedicalServicesRepository medicalServicesRepository) {
        this.medicalServicesRepository = medicalServicesRepository;
    }

    @Override
    public List<MedicalServices> getAll() {
        return medicalServicesRepository.findAll();
    }

    @Override
    public MedicalServices getById(Long id) {
        return medicalServicesRepository.getReferenceById(id);
    }

    @Override
    public MedicalServices save(MedicalServices medicalServices) {
        return medicalServicesRepository.save(medicalServices);
    }
}
