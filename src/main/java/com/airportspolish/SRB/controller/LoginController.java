/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.Logi;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.EventServiceImpl;
import com.airportspolish.SRB.service.impl.LogiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    EventServiceImpl eventServiceImpl;

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping("/logout")
    public String logout(Principal principal, HttpServletRequest request){
        int userId = userService.findUserByUserName(principal.getName()).getId();
        Logi logi = new Logi();
        String who = principal.getName();
        logi.setLogsDesc(who + " wylogował się");
        logi.setUserId(userId);
        logiServiceImpl.saveLog(logi);
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/session-expired")
    public String sessionExpired(HttpServletRequest request, Principal principal) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (username != null) {
                int userId = userService.findUserByUserName(principal.getName()).getId();
                Logi logi = new Logi();
                String who = principal.getName();
                logi.setLogsDesc(who + " wylogował się poprzez zamknięcie przeglądarki");
                logi.setUserId(userId);
                logiServiceImpl.saveLog(logi);
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/index")
    public String goHome(HttpSession httpSession){
        logger.error("test");
        int countNew = eventServiceImpl.getNewCount();
        System.out.println("Count: " + countNew);
        if(countNew != 0){
            httpSession.setAttribute("countNew", countNew);
        }
        return "/index";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}
