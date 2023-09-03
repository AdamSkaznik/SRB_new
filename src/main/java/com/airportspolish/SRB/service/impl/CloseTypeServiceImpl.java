/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.CloseType;
import com.airportspolish.SRB.repository.CloseTypeRepository;
import com.airportspolish.SRB.service.CloseTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloseTypeServiceImpl implements CloseTypeService {
    private static final Logger logger = LoggerFactory.getLogger(CloseTypeServiceImpl.class);

    @Autowired
    CloseTypeRepository closeTypeRepository;

    public CloseTypeServiceImpl(CloseTypeRepository closeTypeRepository) {
        this.closeTypeRepository = closeTypeRepository;
    }

    @Override
    public List<CloseType> getAll() {
        return closeTypeRepository.findAll();
    }

    @Override
    public CloseType findById(Integer id) {
        return closeTypeRepository.getReferenceById(id);
    }

    @Override
    public CloseType save(CloseType closeType) {
        return closeTypeRepository.save(closeType);
    }
}
