/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.ActionsTaken;
import com.airportspolish.SRB.repository.ActionTakenRepository;
import com.airportspolish.SRB.service.ActionTakenServive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionTakenServiceImpl implements ActionTakenServive {
    private static final Logger logger = LoggerFactory.getLogger(ActionTakenServiceImpl.class);

    @Autowired
    ActionTakenRepository actionTakenRepository;

    public ActionTakenServiceImpl(ActionTakenRepository actionTakenRepository) {
        this.actionTakenRepository = actionTakenRepository;
    }

    @Override
    public List<ActionsTaken> getAll() {
        return actionTakenRepository.findAll();
    }
}
