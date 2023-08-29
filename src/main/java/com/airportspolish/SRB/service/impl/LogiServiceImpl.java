/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Logi;
import com.airportspolish.SRB.repository.LogiRepository;
import com.airportspolish.SRB.service.LogiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogiServiceImpl implements LogiService {
    @Autowired
    LogiRepository logiRepository;

    public LogiServiceImpl(LogiRepository logiRepository) {
        this.logiRepository = logiRepository;
    }

    @Override
    public List<Logi> getAll() {
        return logiRepository.findAll();
    }

    @Override
    public void saveLog(Logi logi) {
        logiRepository.save(logi);
    }
}
