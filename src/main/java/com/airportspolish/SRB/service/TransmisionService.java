/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Transmission;

import java.util.List;

public interface TransmisionService {
    List<Transmission> getAll();
    Transmission getById(Long id);
    void saveTransmission(Transmission transmission);
}
