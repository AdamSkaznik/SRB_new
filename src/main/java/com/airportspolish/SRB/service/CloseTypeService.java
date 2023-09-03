/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.CloseType;

import java.util.List;

public interface CloseTypeService {
    List<CloseType> getAll();
    CloseType findById(Integer id);
    CloseType save(CloseType closeType);
}
