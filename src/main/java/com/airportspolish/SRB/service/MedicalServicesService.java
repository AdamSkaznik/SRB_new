/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.MedicalServices;

import java.util.List;

public interface MedicalServicesService {

    List<MedicalServices> getAll();

    MedicalServices getById(Long id);

    MedicalServices save(MedicalServices medicalServices);
}
