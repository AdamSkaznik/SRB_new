/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.model;
// model dla śpb

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_spb")
public class Spb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spbId;
    private String spbName;
    private String spbDesc;
}
