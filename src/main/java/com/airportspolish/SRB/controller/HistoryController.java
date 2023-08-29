/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.service.impl.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HistoryController {
    @Autowired
    HistoryServiceImpl historyServiceImpl;

//    @GetMapping("/history/{historyId}")
//    public String historyView(Model model, @PathVariable Long eventId){
//        List<History> histories = historyServiceImpl.getAll();
//    }
}
