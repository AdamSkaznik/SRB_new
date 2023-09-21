/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.*;
import com.airportspolish.SRB.repository.RoleRepository;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminControler {
    @Autowired
    UserService userService;
    @Autowired
    LevelServiceImpl levelServiceImpl;
    @Autowired
    PlaceServiceImpl placeServiceImpl;
    @Autowired
    ZoneServiceImpl zoneServiceImpl;
    @Autowired
    PatrolServiceImpl patrolServiceImpl;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EventTypeServiceImpl eventTypeServiceImpl;
    @Autowired
    EventStatusServiceImpl eventStatusServiceImpl;
    @Autowired
    InvolvedServicesServiceImpl involvedServicesServiceImpl;
    @Autowired
    SpbServiceImpl spbServiceImpl;

    @GetMapping("/admin/addLevel")
    public String addLevel(Model model, Level level){
        model.addAttribute("level", level);
        return "/admin/addLevel";
    }
    @PostMapping("/admin/saveLevel")
    public String saveLevel(Level level, Principal principal){
        level.setLevelActive(true);
      levelServiceImpl.save(level);
      int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc(principal.getName() + " dodał nowy poziom");
        logiServiceImpl.saveLog(logi);
        return "redirect:/index";
    }
    @GetMapping("/admin/place")
    public String place() {
        return "/admin/place";
    }



    @GetMapping("/admin/addEventStatus")
    public String addEventStatus(Model model, EventStatus eventStatus) {
        model.addAttribute("eventStatus", eventStatus);
        return "/admin/addEventStatus";
    }

    @PostMapping("/admin/saveEventStatus")
    public String saveEvenetStatus(EventStatus eventStatus, Principal principal) {
        eventStatus.setEventStatusActive(true);
//        boolean end = eventStatus.ge;
//        if (end === null){
//            end = false;
//        }
//        eventStatus.setEventStatusSequence(end);
        eventStatusServiceImpl.saveStatusEvent(eventStatus);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc(principal.getName() + " dodał nowy poziom");
        logiServiceImpl.saveLog(logi);
        return "redirect:/admin/eventStatus";
    }

    @GetMapping("/admin/addPlace")
    public String addPlace(Place place, Model model) {
        model.addAttribute("place", place);
        return "/admin/addPlace";
    }

    @PostMapping("/admin/savePlace")
    public String savePlace(Place place, Principal principal){
        place.setPlaceActive(true);
        placeServiceImpl.savePlace(place);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc(principal.getName() + " dodał nowy poziom");
        logiServiceImpl.saveLog(logi);
        return "redirect:/index";
    }
    @GetMapping("/admin/zone")
    public String zone() {
        return "/admin/zone";
    }

    @GetMapping("/admin/addZone")
    public String addZone(Zone zone, Model model){
        model.addAttribute("zone", zone);
        return "admin/addZone";
    }
    @PostMapping("/admin/saveZone")
    public String saveZone(Zone zone, Principal principal) {
        zone.setZoneActive(true);
        zoneServiceImpl.saveZone(zone);
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc(principal.getName() + " dodał nową strefę");
        logiServiceImpl.saveLog(logi);
        return "redirect:/index";
    }

    @GetMapping("/admin/eventStatus")
    public String eventStatus() {
        return "/admin/eventStatus";
    }

    @GetMapping("/admin/eventType")
    public String eventType(){
        return "/admin/eventType";
    }

    @GetMapping("/admin/addEventType")
    public String addEventType(EventType eventType){
        return "/admin/addEventType";
    }

    @GetMapping("/admin/patrol")
    public String patrol(){
        return "/admin/patrol";
    }

    @GetMapping("/admin/patrolStatus")
    public String patrolStatus() {
        return "/admin/PatrolStatus";
    }


    @GetMapping("/admin/level")
    public String level(Model model, Level level)
    {
        model.addAttribute("level", level);
        return "/admin/level";
    }

    @GetMapping("/admin/users")
    public String users() {
    return "/admin/users";
    }

    @GetMapping("/admin/logi")
    public String logi(){return "/admin/logi";}

    @GetMapping("/admin/addUser")
    public ModelAndView newUser() {
    User user = new User();
    ModelAndView mav = new ModelAndView();
        mav.addObject("user", user);
    List<Role> roles = roleRepository.findAll();
        mav.addObject("allRoles", roles);
        return mav;
    }
    @GetMapping("/admin/editUser/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Integer id) {
        User user = userService.findById(id);
        ModelAndView mav = new ModelAndView("user_form");
        mav.addObject("user", user);

        List<Role> roles = roleRepository.findAll();

        mav.addObject("allRoles", roles);

        return mav;
    }
}
