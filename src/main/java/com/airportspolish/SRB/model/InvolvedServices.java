/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// model dla zaangażowanych służb zewnętrznych
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_involvedServices")
public class InvolvedServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long involvedId;
    private String involvedName;
    private String involvedDesc;
    private boolean involvedActive;
}
