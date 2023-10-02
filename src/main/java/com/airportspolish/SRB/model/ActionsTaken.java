/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// model dla podjętych czynności
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_actions")
public class ActionsTaken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;
    private String actionName;
    private String actionDesc;
    private boolean actionActive;
}
