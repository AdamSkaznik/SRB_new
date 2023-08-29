/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Procedures;

import java.util.List;

public interface ProceduresService {
    List<Procedures> getAll();
    Procedures getById(Long id);
    void saveProcedures(Procedures procedures);
}
