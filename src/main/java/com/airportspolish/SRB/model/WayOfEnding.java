/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */


//sposoby zakończenia - słownik
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
@Table(name = "tab_ending")
//model dla sposobów zakończenia
public class WayOfEnding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wayOfEndingId;
    private String wayOfEndingName;
    private String wayOdEndingDesc;
}
