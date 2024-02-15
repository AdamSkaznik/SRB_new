/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//model dla typów zamknięcia
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_closeType")
public class CloseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int closeTypeId;
    private String closeTypeName;
    private String closeTypeDesc;
    private boolean active;

}
