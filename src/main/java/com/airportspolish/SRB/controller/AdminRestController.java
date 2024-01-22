/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.*;
import com.airportspolish.SRB.repository.LevelRepository;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AdminRestController {
    private static final Logger logger = LoggerFactory.getLogger(AdminRestController.class);
    @Autowired
    UserService userService;
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    LevelServiceImpl levelServiceImpl;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    EventStatusServiceImpl eventStatusServiceImpl;
    @Autowired
    PatrolServiceImpl patrolServiceImpl;
    @Autowired
    PatrolStatusServiceImpl patrolStatusServiceImpl;
    @Autowired
    EventTypeServiceImpl eventTypeServiceImpl;
    @Autowired
    InvolvedServicesServiceImpl involvedServicesServiceImpl;
    @Autowired
    SpbServiceImpl spbServiceImpl;
   @Autowired
   CloseTypeServiceImpl closeTypeServiceImpl;
   @Autowired
   MedicalServicesServiceImpl medicalServicesServiceImpl;

    @PostMapping("/api/admin/saveLevel")
    public @ResponseBody Level saveLevel(@RequestBody Level level, Principal principal) {
        try {
            level.setLevelActive(true);
            int who = userService.findUserByUserName(principal.getName()).getId();
            Logi logi = new Logi();
            logi.setUserId(who);
            logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy poziom o nazwie : " + level.getLevelName());
            logiServiceImpl.saveLog(logi);
        }catch (Exception e) {
            logger.error("Błąd podczas zapisu poziomu przez Admina przez RestApi: " + e);
        }

        return levelRepository.save(level);
    }

    @PostMapping("/api/admin/saveEventStatus")
    public @ResponseBody
    EventStatus eventStatus(@RequestBody EventStatus eventStatus, Principal principal) {
        try {
            eventStatus.setEventStatusActive(true);
            int who = userService.findUserByUserName(principal.getName()).getId();
            Logi logi = new Logi();
            logi.setUserId(who);
            logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy status wydarzenia nazwie : " + eventStatus.getEventStatusName());
            logiServiceImpl.saveLog(logi);
        } catch (Exception e) {
            logger.error("Błąd podczas zapisu statusu w RestApi przez Admina: " + e);
        }

        return eventStatusServiceImpl.saveStatusEvent(eventStatus);
    }

    @PostMapping("/api/admin/saveEventType")
    public @ResponseBody EventType eventType(@RequestBody EventType eventType, Principal principal){
        try {
            eventType.setEventTypeActive(true);
            int who = userService.findUserByUserName(principal.getName()).getId();
            Logi logi = new Logi();
            logi.setUserId(who);
            logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy typ wydarzenia o nazwie : " + eventType.getEventTypeName());
            logiServiceImpl.saveLog(logi);
        }catch (Exception e) {
            logger.error("Błąd podczas zapisu typu w RestApi przez Admina: " + e);
        }

        return eventTypeServiceImpl.saveEventType(eventType);
    }
    @PostMapping("/api/admin/savePatrol")
    public @ResponseBody
    Patrol patrol(@RequestBody Patrol patrol, Principal principal){
        try {
            patrol.setPatrolActive(true);
            int who = userService.findUserByUserName(principal.getName()).getId();
            Logi logi = new Logi();
            logi.setUserId(who);
            logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy patrol o nazwie : " + patrol.getPatrolName());
            logiServiceImpl.saveLog(logi);
        } catch (Exception e) {
            logger.error("Błąd podczas zapisu patrolu w RestApi przez Admina: " + e);
        }

        return patrolServiceImpl.savePatrol(patrol);
    }

    @PostMapping("/api/admin/savePatrolStatus")
    public @ResponseBody
    PatrolStatus patrolStatus(@RequestBody PatrolStatus patrolStatus, Principal principal) {
        try {
            patrolStatus.setPatrolStatusActive(true);
            patrolStatus.setPatrolStatusName(patrolStatus.getPatrolStatusName());
            patrolStatus.setPatrolStatusDesc(patrolStatus.getPatrolStatusDesc());
            System.out.println("Patrol status : " + patrolStatus.getPatrolStatusName() + " " + patrolStatus.getPatrolStatusDesc());
            int who = userService.findUserByUserName(principal.getName()).getId();
            Logi logi = new Logi();
            logi.setUserId(who);
            logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy status patrolu o nazwie : " + patrolStatus.getPatrolStatusName());
            logiServiceImpl.saveLog(logi);
        } catch (Exception e) {
            logger.error("Błąd podczas zapisu statusu patrolu w RestApi przez Admina: " + e);
        }

        return patrolStatusServiceImpl.savePatrolStatus(patrolStatus);
    }

    @RequestMapping(path = "/api/involved/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvolvedServices>> allServices(){
        try {
            return new ResponseEntity<List<InvolvedServices>>(involvedServicesServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania służ wspomagających z API");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/admin/saveInvolved")
    public @ResponseBody
    InvolvedServices involvedServices(@RequestBody InvolvedServices involvedServices, Principal principal){
        try {
            involvedServices.setInvolvedName(involvedServices.getInvolvedName());
            involvedServices.setInvolvedDesc(involvedServices.getInvolvedDesc());
            involvedServices.setInvolvedActive(true);
            int who = userService.findUserByUserName(principal.getName()).getId();
            Logi logi = new Logi();
            logi.setUserId(who);
            logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nową służbę wspomagającą  : " + involvedServices.getInvolvedName());
            logiServiceImpl.saveLog(logi);
        } catch (Exception e){
            logger.error("Błąd podczas dodawania służby wspomagającej w RestApi przez Admina: " + e);
        }

        return involvedServicesServiceImpl.save(involvedServices);
    }

    @RequestMapping(path = "/api/spb/v1")
    public ResponseEntity<List<Spb>> allSpb(){
        try {
            return new ResponseEntity<List<Spb>>(spbServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/admin/saveSpb")
    public @ResponseBody
    Spb spb(@RequestBody Spb spb, Principal principal){
        spb.setSpbName(spb.getSpbName());
        spb.setSpbDesc(spb.getSpbDesc());
        spb.setSpbActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy Środek Przymusu Bezpośredniego : " + spb.getSpbName());
        logiServiceImpl.saveLog(logi);
        return spbServiceImpl.save(spb);
    }

    @RequestMapping(path = "/api/closeType/v1")
    public ResponseEntity<List<CloseType>> allCloseType(){
        try {
            return new ResponseEntity<List<CloseType>>(closeTypeServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/admin/saveCloseType")
    public @ResponseBody
    CloseType closeType(@RequestBody CloseType closeType, Principal principal){
        closeType.setCloseTypeName(closeType.getCloseTypeName());
        closeType.setCloseTypeDesc(closeType.getCloseTypeDesc());
        closeType.setActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy sposób zakończenia : " + closeType.getCloseTypeName());
        logiServiceImpl.saveLog(logi);
        return closeTypeServiceImpl.save(closeType);
    }

    @PostMapping("/api/admin/saveMedical")
    public @ResponseBody
    MedicalServices medicalServices(@RequestBody MedicalServices medicalServices, Principal principal){
        medicalServices.setMedicalServicesName(medicalServices.getMedicalServicesName());
        medicalServices.setMedicalServicesDesc(medicalServices.getMedicalServicesDesc());
        medicalServices.setMedicalServicesActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nową służbę medyczną : " + medicalServices.getMedicalServicesName());
        logiServiceImpl.saveLog(logi);
        return medicalServicesServiceImpl.save(medicalServices);
    }
}
