/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

//wydane dyspozycje

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructions")
// model dla dyspozycji
public class Instructions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructionsId;
    private String instructionsDesc;
    private String createdBy;
    private  boolean instructionsActive;
    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date instructionsDate;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "eventId", nullable = true)
    private Event event;

}
