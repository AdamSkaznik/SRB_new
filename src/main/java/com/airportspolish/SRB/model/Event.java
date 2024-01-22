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
//    kto zgłasza
    private String reporting;
    // data i czas wprowadzenia
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportingDate;
//   Data i czas wysłania patrolu
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date patrolSent;
    // Data i czas podjęcia interwencji
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date intervention;
    // Data i czas zakończenia interwencji
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endIntervention;
        // rok (dla celów statystycznych)
    @DateTimeFormat(pattern = "yyyy")
    private String year;
    // opis interwencji
    private String eventDesc;
    // czy użyto SPB
    private boolean useSPB;
    // czy strzelano
    private boolean shot;
    // czy wysłano komunikat
    private boolean messages;
//    private boolean medicalInside;
//    private boolean medicalOutside;
    // kroki przed użyciem SPB
    private String stepsBeforeUseSPB;
    // kroki po użyciu SPB
    private String stepsAfterUseSPB;
    // opis zdrowie
    private String health;
    // czynności wykonywano z :
    private String activitiesWith;
    // inne informacje
    private String otherRelevantInformation;
    // dodatkowe informacje o osobie/osobach
    private String otherPersonInformation;

    private String activitiesRelationSPB;
    private String activities;
    // czy zakończono
    private boolean isEnd;
    //utworzone przez
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
    @JoinTable(name = "eventMedical", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "medical_id"))
    private Set<MedicalServices> medicalServices = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "eventSpb", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "spb_id"))
    private Set<Spb> spbs = new HashSet<>();



}
