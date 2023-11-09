/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.EventServiceImpl;
import com.airportspolish.SRB.service.impl.LogiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class LoginController {
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
//    @PostMapping("/login")
//    public String zalogowano(Principal principal){
//        int userId = userService.findUserByUserName(principal.getName()).getId();
//        System.out.println("ZALOGOWANOOOOOOOO");
//        Logi logi = new Logi();
//        String who = principal.getName();
//        logi.setLogsDesc(who + " zalogował się");
//        logi.setUserId(userId);
//        logiServiceImpl.saveLog(logi);
//        return "redirect:/index";
//    }

//    @GetMapping("/logout")
//    public String logout(Principal principal, HttpServletRequest request){
//        int userId = userService.findUserByUserName(principal.getName()).getId();
//        Logi logi = new Logi();
//        String who = principal.getName();
//        logi.setLogsDesc(who + " wylogował się");
//        logi.setUserId(userId);
//        logiServiceImpl.saveLog(logi);
//        HttpSession session = request.getSession();
//        session.invalidate();
//        return "redirect:/login";
//    }
//
//    @GetMapping("/session-expired")
//    public String sessionExpired(HttpServletRequest request, Principal principal) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            String username = (String) session.getAttribute("username");
//            if (username != null) {
//                int userId = userService.findUserByUserName(principal.getName()).getId();
//                Logi logi = new Logi();
//                String who = principal.getName();
//                logi.setLogsDesc(who + " wylogował się poprzez zamknięcie przeglądarki");
//                logi.setUserId(userId);
//                logiServiceImpl.saveLog(logi);
//            }
//        }
//        return "redirect:/login";
//    }

    @GetMapping("/index")
    public String goHome(HttpSession httpSession){
        int countNew = eventServiceImpl.getNewCount();
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
