/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.InvolvedServices;

import java.util.List;

public interface InvolvedServicesService {
    List<InvolvedServices> getAll();
    InvolvedServices getById(Long id);
    void save(InvolvedServices involvedServices);
//    List<InvolvedServices> search(String involvedName);
}
