/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Spb;

import java.util.List;

public interface SpbService {
    List<Spb> getAll();
    Spb getById(Long id);
    void save (Spb spb);
}
