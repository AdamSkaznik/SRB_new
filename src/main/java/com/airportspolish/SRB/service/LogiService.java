/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Logi;

import java.util.List;

public interface LogiService {
    List<Logi> getAll();
//    Logi logs getById(Long id)

    void saveLog(Logi logi);
}
