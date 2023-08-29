/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */


// patrole - słownik
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
@Table(name = "tab_patrol")
public class Patrol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patrolId;
    private String patrolName;
    private String patrolDesc;
    private boolean patrolActive;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "status_id")
//    private PatrolStatus patrolStatus;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patrol_id")
//    private Patrol patrol;
}
