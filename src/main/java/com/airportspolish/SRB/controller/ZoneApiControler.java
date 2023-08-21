/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.Logi;
import com.airportspolish.SRB.model.Zone;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.LogiServiceImpl;
import com.airportspolish.SRB.service.impl.ZoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ZoneApiControler {
    @Autowired
    ZoneServiceImpl zoneServiceImpl;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    UserService userService;

    @PostMapping("/api/saveZone")
    public @ResponseBody
    Zone saveZone(@RequestBody Zone zone, Principal principal) {
        int who = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        logi.setUserId(who);
        logi.setLogsDesc("Administrator : " + principal.getName() + " dodał nową strefę o nazwie : " + zone.getZoneName());
        logiServiceImpl.saveLog(logi);
        return zoneServiceImpl.saveZone(zone);
}

}
