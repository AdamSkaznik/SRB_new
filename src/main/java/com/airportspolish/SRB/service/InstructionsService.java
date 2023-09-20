/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Instructions;

import java.util.List;

public interface InstructionsService {

    List<Instructions> getAll();
    List<Instructions> getByEventId(Long eventId);
    Instructions getById(Long id);
//    Instructions getByName(String name);
    void saveInstructions(Instructions instructions);
}
