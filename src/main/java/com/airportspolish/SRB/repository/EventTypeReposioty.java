/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTypeReposioty extends JpaRepository<EventType, Long> {

    String zap_active = "SELECT * FROM tab_event_type WHERE event_type_active = true";
    @Query(value = zap_active, nativeQuery = true)
    public List<EventType> getAllActive();

    String zap_search_active = "SELECT * FROM tab_event_type WHERE event_type_active = true and event_type_name iLIKE %?1%";
    @Query(value = zap_search_active, nativeQuery = true)
    public List<EventType> searchEventType(String eventTypeName);
}
