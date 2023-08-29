/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */


//status patrolu - słownik
package com.airportspolish.SRB.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tab_status_patrolu")
public class PatrolStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patrolStatusId;
    private String patrolStatusName;
    private String patrolStatusDesc;
    private boolean patrolStatusActive;
}
