/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Level;

import java.util.List;

public interface LevelService {

    List<Level> getAll();
    Level getById(Long id);
    void save(Level level);
    List<Level> levelSearch(String levelName);
}
