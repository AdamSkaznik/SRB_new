/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Level;
import com.airportspolish.SRB.repository.LevelRepository;
import com.airportspolish.SRB.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public List<Level> getAll() {
        return levelRepository.findAll();
    }

    @Override
    public Level getById(Long id) {
        return levelRepository.getReferenceById(id);
    }

    @Override
    public void save(Level level) {
        levelRepository.save(level);
    }

    @Override
    public List<Level> levelSearch(String levelName) {
        return levelRepository.getActive(levelName);
    }
}
