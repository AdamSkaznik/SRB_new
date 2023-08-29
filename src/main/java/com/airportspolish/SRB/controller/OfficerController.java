/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.Event;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.EventServiceImpl;
import com.airportspolish.SRB.service.impl.LogiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OfficerController {
    @Autowired
    UserService userService;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    EventServiceImpl eventServiceImpl;

    @GetMapping("/officer/addEvent")
    public String addEvent(Event event, Model model){
        model.addAttribute("event", event);
        return ("/officer/addEvent");
    }
}
