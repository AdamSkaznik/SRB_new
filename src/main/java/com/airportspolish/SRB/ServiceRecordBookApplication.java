/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB;

import com.airportspolish.SRB.utils.SessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.http.HttpSessionListener;

@PropertySource("classpath:db.properties")
@PropertySource("classpath:log4j.properties")
@SpringBootApplication
public class ServiceRecordBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRecordBookApplication.class, args);
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
		return new ServletListenerRegistrationBean<>(new SessionListener());
	}

}
