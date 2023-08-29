/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Instructions;
import com.airportspolish.SRB.repository.InstructionsRepository;
import com.airportspolish.SRB.service.InstructionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructionsServiceImpl implements InstructionsService {
    @Autowired
    InstructionsRepository instructionsRepository;

    public InstructionsServiceImpl(InstructionsRepository instructionsRepository) {
        this.instructionsRepository = instructionsRepository;
    }

    @Override
    public List<Instructions> getAll() {
        return instructionsRepository.findAll();
    }

    @Override
    public Instructions getById(Long id) {
        return instructionsRepository.getReferenceById(id);
    }

//    @Override
//    public Instructions getByName(String name) {
//        return instructionsRepository.ge;
//    }

    @Override
    public void saveInstructions(Instructions instructions) {
        instructionsRepository.save(instructions);
    }
}
