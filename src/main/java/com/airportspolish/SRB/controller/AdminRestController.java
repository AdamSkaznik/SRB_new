/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.*;
import com.airportspolish.SRB.repository.LevelRepository;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AdminRestController {
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

    @PostMapping("/api/admin/saveLevel")
    public @ResponseBody Level saveLevel(@RequestBody Level level, Principal principal) {
        level.setLevelActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy poziom o nazwie : " + level.getLevelName());
        logiServiceImpl.saveLog(logi);
        return levelRepository.save(level);
    }

    @PostMapping("/api/admin/saveEventStatus")
    public @ResponseBody
    EventStatus eventStatus(@RequestBody EventStatus eventStatus, Principal principal) {
        eventStatus.setEventStatusActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy status wydarzenia nazwie : " + eventStatus.getEventStatusName());
        logiServiceImpl.saveLog(logi);
        return eventStatusServiceImpl.saveStatusEvent(eventStatus);
    }

    @PostMapping("/api/admin/saveEventType")
    public @ResponseBody EventType eventType(@RequestBody EventType eventType, Principal principal){
        eventType.setEventTypeActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy typ wydarzenia o nazwie : " + eventType.getEventTypeName());
        logiServiceImpl.saveLog(logi);
        return eventTypeServiceImpl.saveEventType(eventType);
    }
    @PostMapping("/api/admin/savePatrol")
    public @ResponseBody
    Patrol patrol(@RequestBody Patrol patrol, Principal principal){
        patrol.setPatrolActive(true);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy patrol o nazwie : " + patrol.getPatrolName());
        logiServiceImpl.saveLog(logi);
        return patrolServiceImpl.savePatrol(patrol);
    }

    @PostMapping("/api/admin/savePatrolStatus")
    public @ResponseBody
    PatrolStatus patrolStatus(@RequestBody PatrolStatus patrolStatus, Principal principal) {
        patrolStatus.setPatrolStatusActive(true);
        patrolStatus.setPatrolStatusName(patrolStatus.getPatrolStatusName());
        patrolStatus.setPatrolStatusDesc(patrolStatus.getPatrolStatusDesc());
        System.out.println("Patrol status : " + patrolStatus.getPatrolStatusName() + " " + patrolStatus.getPatrolStatusDesc());
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nowy status patrolu o nazwie : " + patrolStatus.getPatrolStatusName());
        logiServiceImpl.saveLog(logi);
        return patrolStatusServiceImpl.savePatrolStatus(patrolStatus);
    }

}
