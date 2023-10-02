/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.controller;

import com.airportspolish.SRB.model.*;
import com.airportspolish.SRB.service.UserService;
import com.airportspolish.SRB.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AppRestController {
    private static final Logger logger = LoggerFactory.getLogger(AppRestController.class);
    @Autowired
    EventServiceImpl eventServiceImpl;
    @Autowired
    PatrolServiceImpl patrolServiceImpl;
    @Autowired
    PlaceServiceImpl placeServiceImpl;
    @Autowired
    LevelServiceImpl levelServiceImpl;
    @Autowired
    ZoneServiceImpl zoneServiceImpl;
    @Autowired
    EventStatusServiceImpl eventStatusServiceImpl;
    @Autowired
    UserService userService;
    @Autowired
    EventTypeServiceImpl eventTypeServiceImpl;
    @Autowired
    PatrolStatusServiceImpl patrolStatusServiceImpl;
    @Autowired
    LogiServiceImpl logiServiceImpl;
    @Autowired
    InvolvedServicesServiceImpl involvedServicesServiceImpl;
    @Autowired
    InstructionsServiceImpl instructionsService;
    @Autowired
    CloseTypeServiceImpl closeTypeServiceImpl;


    @RequestMapping(path = "/events/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getAllEvents() {
        try {
            return new ResponseEntity<List<Event>>(eventServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania interwencji z API:" + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @RequestMapping(path = "/patrol/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patrol>> getAllPatrol() {
        try {
            return new ResponseEntity<List<Patrol>>(patrolServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania patrolu z API : " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/patrol/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patrol>> searchPatrol(String term){
        try {
            return new ResponseEntity<List<Patrol>>(patrolServiceImpl.getByName(term), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania poszukiwanych danych z API /patrol/search/v1" + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(path = "/place/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Place>> getAllPlaces() {
        try {
            return new ResponseEntity<List<Place>>(placeServiceImpl.getAll(), HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Błąd podczas pobierania placu z API : " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/level/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Level>> getAllLevel() {
        try {
            return new ResponseEntity<List<Level>>(levelServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania terminala z API : " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/zone/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Zone>> getAllZone() {
        try {
            return new ResponseEntity<List<Zone>>(zoneServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania strefy z API : " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/eventStatus/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventStatus>> getAllEventStatus() {
        try {
            return new ResponseEntity<List<EventStatus>>(eventStatusServiceImpl.getAll(), HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Błąd podczas pobierania statusu interwencji z API : " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/users/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAll() {
       try {
           return new ResponseEntity<List<User>>(userService.all(), HttpStatus.OK);
       } catch (Exception e) {
           logger.error("Błąd podczas pobierania użytkowników z API : " + e);
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
    @RequestMapping(path = "/eventType/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventType>> getAllEventType() {
        try {
            return new ResponseEntity<List<EventType>>(eventTypeServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania typu wydarzenia z API : " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/patrolStatus/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatrolStatus>> getAllPatrolStatus() {
        try {
            return new ResponseEntity<List<PatrolStatus>>(patrolStatusServiceImpl.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/logs/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Logi>> getAllLogs(){
        try {
            return new ResponseEntity<List<Logi>>(logiServiceImpl.getAll(), HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Błąd podczas pobierania listy logów z API /logi/v1 " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/eventType/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventType>> eventTypseSearch(String term) {
        try {
            return new ResponseEntity<List<EventType>>(eventTypeServiceImpl.searchAllActive(term), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania poszukiwanych danych z API /eventType/search/v1 " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/level/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Level>> levelSearch(String term) {
        try {
            return new ResponseEntity<List<Level>>(levelServiceImpl.levelSearch(term), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania poszukiwanych danych z API /level/search/v1 " + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/place/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Place>> placeSearch(String term) {
    try {
        return new ResponseEntity<List<Place>>(placeServiceImpl.getSearch(term), HttpStatus.OK);
    } catch (Exception e) {
        logger.error("Błąd podczas pobierania poszukiwanych danych z API /place/search/v1" + e);
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }

    @RequestMapping(path = "/zone/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Zone>> zoneSearch(String term) {
        try {
            return new ResponseEntity<List<Zone>>(zoneServiceImpl.getSearch(term), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania poszukiwania danych z API /zone/search/v1" + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/closeType/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CloseType>> closeTypeSearch(String term){
        try {
            return new ResponseEntity<List<CloseType>>(closeTypeServiceImpl.search(term), HttpStatus.OK);
        } catch (Exception e){
            logger.error("Błąd podczas pobierania poszukiwania danych z API /closeType/search/v1" + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/api/instructions/v1/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Instructions>> instruction(@PathVariable Long eventId){
        try {
            return new ResponseEntity<List<Instructions>>(instructionsService.getByEventId(eventId), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Błąd podczas pobierania poszukiwania danych z API /instructions/v1" + e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
