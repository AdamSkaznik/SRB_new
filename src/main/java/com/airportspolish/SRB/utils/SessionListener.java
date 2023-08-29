/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.utils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().setAttribute("sessionExpired", true);
    }


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Pusta metoda, gdyż Listener wykorzystujemy do logowania w przypadku zamknięcia przeglądarki
    }
}
