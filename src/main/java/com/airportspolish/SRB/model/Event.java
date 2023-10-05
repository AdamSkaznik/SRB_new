/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

// głowna tabela ze zdarzeniami

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//model dla interwencji
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int eventNr;
    private String eventSystemNr;
    private String reporting;
//    private String eventDesc;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportingDate;
//    @Modifying
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date patrolSent;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date intervention;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endIntervention;

    @DateTimeFormat(pattern = "yyyy")
    private String year;
    private String eventDesc;
    private boolean useSPB;
    private boolean shot;
    private boolean messages;
//    private boolean medicalInside;
//    private boolean medicalOutside;
    private String stepsBeforeUseSPB;
    private String stepsAfterUseSPB;
    private String health;
    private String activitiesWith;
    private String otherRelevantInformation;
    private String activitiesRelationSPB;
    private String activities;
    private boolean isEnd;
    private String createdBy;
    @Transient
//    @JsonIgnore
    private Long categoryId;
    @Transient
    private Long zoneTmpId;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "eventTypeId",  nullable = true)
//    @JsonIgnore
    private EventType eventType;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "eventLevelId", nullable = true)
//    @JsonIgnore
    private Level level;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "eventPlaceId",  nullable = true)
//    @JsonIgnore
    private Place place;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "eventZoneId", nullable = true)
//    @JsonIgnore
    private Zone zone;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "personId", columnDefinition = "Long", nullable = true)
//    private Person person;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "eventStatusId", nullable = true)
//    @JsonIgnore
    private EventStatus eventStatus;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "patrolId", nullable = true)
//    @JsonIgnore
    private Patrol patrol;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "eventsInstructions", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "instructions_id"))
//    @JsonIgnore
    private Set<Instructions> instructions = new HashSet<>();
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "eventsPatrol", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "patrol_id"))
//    private Set<Patrol> patrols = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "closeTypeId", nullable = true)
    private CloseType closeType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "eventInvolved", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "involved_id"))
    private Set<InvolvedServices> involvedServices = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "eventSpb", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "spb_id"))
    private Set<Spb> spbs = new HashSet<>();



}
