/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.*;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class EventController {
    @Autowired
    EventServiceImpl eventServiceImpl;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    UserService userService;
    @Autowired
    EventTypeServiceImpl eventTypeServiceImpl;
    @Autowired
    ZoneServiceImpl zoneServiceImpl;
    @Autowired
    PlaceServiceImpl placeServiceImpl;
    @Autowired
    LevelServiceImpl levelServiceImpl;
    @Autowired
    EventStatusServiceImpl eventStatusServiceImpl;
    @Autowired
    PatrolServiceImpl patrolServiceImpl;
    @Autowired
    InstructionsServiceImpl instructionsServiceImpl;
    @Autowired
    CloseTypeServiceImpl closeTypeServiceImpl;
    @Autowired
    InvolvedServicesServiceImpl involvedServicesServiceImpl;
    @Autowired
    HistoryServiceImpl historyServiceImpl;
    @Autowired
    SpbServiceImpl spbServiceImpl;

@PostMapping("/api/saveEvent")
    public ResponseEntity<Void> saveEvent(@RequestBody Temp temp, Principal principal){
    System.out.println("Przekazane dane : " + temp.getTempReporting() + "; " + temp.getTempDesc() + "; " + temp.getTempZoneId() + "; " + temp.getTempLevelId()+"; " + temp.getTempPlaceId());
    Long id1 = temp.getTempZoneId();
    Long id2 = temp.getTempCategoryId();
    Long id3 = temp.getTempPlaceId();
    Long id4 = temp.getTempLevelId();
    Zone zone = zoneServiceImpl.getById(id1);
    boolean tempNewRecord = false;
    System.out.println("Zone : " + zone.getZoneId() + "; " + zone.getZoneName());
    EventType eventType = eventTypeServiceImpl.getById(id2);
    System.out.println("Event Type :" + eventType.getEventTypeId() + "; " + eventType.getEventTypeName());
    Place place = placeServiceImpl.getById(id3);
    System.out.println("Place : " + place.getPlaceId() + "; " + place.getPlaceName());
    Level level = levelServiceImpl.getById(id4);
    System.out.println("Level : " + level.getLevelId() + "; " + level.getLevelName());
    EventStatus eventStatus = eventStatusServiceImpl.getById(1);
    Patrol patrol = patrolServiceImpl.getById(1);
        int year = Year.now().getValue();
        String rok = String.valueOf(year);
        Event checkLdz = eventServiceImpl.getLast(rok);
        Integer lastLdz = null;
        if (checkLdz == null){
            lastLdz = 0;
        } else {
            lastLdz = checkLdz.getEventNr();
        }
        int newLdz = lastLdz+1;
    LocalDateTime now = LocalDateTime.now();
    Date date = new Date();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy");
    String newSystemNr = "KD - " + newLdz +"/" + dtf.format(now);
    System.out.println("Ldz system : " + newSystemNr);
    try {
        Event event = new Event();
        event.setEventNr(newLdz);
        event.setReporting(temp.getTempReporting());
//        event.setCategoryId(temp.getTempCategoryId());
//        event.setReportingDate();
        event.setEventType(eventType);
        event.setPlace(place);
        event.setZone(zone);
        event.setLevel(level);
//        event.setEventStatus();
        event.setEventDesc(temp.getTempDesc());
        event.setYear(dtf1.format(now));
        event.setEventSystemNr(newSystemNr);
        event.setCreatedBy(principal.getName());
        event.setEventStatus(eventStatus);
        event.setPatrol(patrol);
        eventServiceImpl.saveEvent(event);
        History history = new History();
        history.setHistoryDesc("Dodano nową interwencję przez : " + principal.getName());
        history.setEvent(event);
        historyServiceImpl.saveHistory(history);

    } catch (Exception e) {
        e.printStackTrace();
    }
    return new ResponseEntity<Void>(HttpStatus.OK);
}

@PostMapping("/api/saveEventAddPatrol")
    public ResponseEntity<Void> saveEventAddPatrol(@RequestBody Temp temp, Event event, Principal principal){
    System.out.println("Przekazane dane : " + temp.getTempEventId()+"; " + temp.getTempPatrolId());
    Patrol patrol = patrolServiceImpl.getById(temp.getTempPatrolId());
    EventStatus eventStatus = eventStatusServiceImpl.getById(2);
    try {
        History history = new History();
        history.setHistoryDesc("Dodano do obsługi patrol przez : " + principal.getName());
        history.setEvent(event);
        historyServiceImpl.saveHistory(history);
        Event event1 = eventServiceImpl.getById(temp.getTempEventId());
        event.setId(event1.getId());
        event.setCreatedBy(event1.getCreatedBy());
        event.setEventDesc(event1.getEventDesc());
        event.setEventNr(event1.getEventNr());
        event.setEventSystemNr(event1.getEventSystemNr());
        event.setReporting(event1.getReporting());
        event.setReportingDate(event1.getReportingDate());
        event.setYear(event1.getYear());
        event.setEventType(event1.getEventType());
        event.setLevel(event1.getLevel());
        event.setPlace(event1.getPlace());
        event.setZone(event1.getZone());
        event.setPatrol(patrol);
        event.setEventStatus(eventStatus);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        event.setPatrolSent(date);
        eventServiceImpl.saveEvent(event);
//        History history = new History();
//        history.setHistoryDesc("Dodano do obsługi patrol przez : " + principal.getName());
//        history.setEvent(event);
//        historyServiceImpl.saveHistory(history);
//        eventServiceImpl.updatePatrol(Long.valueOf(patrol.getPatrolId()), eventStatus.getEventStatusId(), temp.getTempEventId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

@PostMapping("/api/saveWork/{id}")
public ResponseEntity<Void> saveWork(@PathVariable Long id, Principal principal, Event event){
    try {
        Event event1 = eventServiceImpl.getById(id);
        System.out.println("Przekazane id : " + id);
        EventStatus eventStatus = eventStatusServiceImpl.getById(3);
        event.setId(event1.getId());
        event.setCreatedBy(event1.getCreatedBy());
        event.setEventDesc(event1.getEventDesc());
        event.setEventNr(event1.getEventNr());
        event.setEventSystemNr(event1.getEventSystemNr());
        event.setReporting(event1.getReporting());
        event.setReportingDate(event1.getReportingDate());
        event.setYear(event1.getYear());
        event.setEventType(event1.getEventType());
        event.setLevel(event1.getLevel());
        event.setPlace(event1.getPlace());
        event.setZone(event1.getZone());
        event.setPatrol(event1.getPatrol());
        event.setEventStatus(event1.getEventStatus());
        event.setPatrol(event1.getPatrol());
        event.setEventStatus(eventStatus);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        event.setIntervention(date);
        eventServiceImpl.saveEvent(event);
        History history = new History();
        history.setHistoryDesc("Patrol rozpoczął interwencję");
        history.setEvent(event);
        historyServiceImpl.saveHistory(history);
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
@PostMapping("/api/saveIntervention/{id}")
    public ResponseEntity<Void> saveIntervention(@PathVariable Long id, Event event, Principal principal){
    EventStatus eventStatus = eventStatusServiceImpl.getById(3);
    try {
        Event event1 = eventServiceImpl.getById(id);
        event.setId(event1.getId());
        event.setCreatedBy(event1.getCreatedBy());
        event.setEventDesc(event1.getEventDesc());
        event.setEventNr(event1.getEventNr());
        event.setEventSystemNr(event1.getEventSystemNr());
        event.setReporting(event1.getReporting());
        event.setReportingDate(event1.getReportingDate());
        event.setYear(event1.getYear());
        event.setEventType(event1.getEventType());
        event.setLevel(event1.getLevel());
        event.setPlace(event1.getPlace());
        event.setZone(event1.getZone());
        event.setPatrol(event1.getPatrol());
        event.setEventStatus(eventStatus);
        eventServiceImpl.saveEvent(event);
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

@PostMapping("/api/saveInstructions")
public ResponseEntity<Void> saveNewInstructions(@RequestBody Temp temp, Principal principal){
    Event event = eventServiceImpl.getById(temp.getTempEventId());
    try {
        Instructions instructions = new Instructions();
        instructions.setInstructionsDesc(temp.getTempDesc());
        instructions.setInstructionsActive(true);
        instructions.setEvent(event);
        instructions.setCreatedBy(principal.getName());
        instructionsServiceImpl.saveInstructions(instructions);
        History history = new History();
        history.setHistoryDesc("Do interwencji dodano nowe polecenia wydane przez : " + principal.getName());
        history.setEvent(event);
        historyServiceImpl.saveHistory(history);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
@GetMapping("/details/{id}")
public String details(@PathVariable Long id, Model model){
    Event event = eventServiceImpl.getById(id);
    EventType eventType = eventTypeServiceImpl.getById(event.getEventType().getEventTypeId());
    Place place = placeServiceImpl.getById(event.getPlace().getPlaceId());
    Level level = levelServiceImpl.getById(event.getLevel().getLevelId());
    Zone zone = zoneServiceImpl.getById(event.getZone().getZoneId());
    List<InvolvedServices> allInvolved = involvedServicesServiceImpl.getAll();
    List<Instructions> instructions = instructionsServiceImpl.getByEventId(id);
    model.addAttribute("event", event);
    model.addAttribute("eventType", eventType);
    model.addAttribute("place", place);
    model.addAttribute("level", level);
    model.addAttribute("zone", zone);
    model.addAttribute("instructions", instructions);
//    model.addAttribute("allInvolved", allInvolved);
    return "/details";
}

@GetMapping("/close/{id}")
    public String close(@PathVariable Long id, Model model){
    Event event = eventServiceImpl.getById(id);
    List<InvolvedServices> allInvolved = involvedServicesServiceImpl.getAll();
    System.out.println("AllInvolved : " + allInvolved);
    List<Spb> spbs = spbServiceImpl.getAll();
    model.addAttribute("event", event);
    model.addAttribute("allInvolved", allInvolved);
    model.addAttribute("spbs", spbs);
    return "/close";
}
}
