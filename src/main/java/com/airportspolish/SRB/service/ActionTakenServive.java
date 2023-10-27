/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.ActionsTaken;

import java.util.List;

public interface ActionTakenServive {
    List<ActionsTaken> getAll();
}
