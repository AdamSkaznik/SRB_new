/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patrol_history")
public class PatrolHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patrolHistoryId;
    @CreationTimestamp
    private Timestamp created;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "patrol_id")
    private Patrol patrol;
    private String userCreated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private PatrolStatus patrolStatus;
}
