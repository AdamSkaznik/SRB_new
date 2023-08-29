/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    String zap_data = "SELECT * FROM events WHERE reporting_date = ?1";
    @Query(value = zap_data, nativeQuery = true)
    List<Event> getByDate(String reportingDate);

    String zap_oldLdz = "SELECT * FROM events where year = ?1 order by id DESC limit 1 ";
    @Query(value = zap_oldLdz, nativeQuery = true)
    Event getLast(String year);

    String update_patrol="UPDATE events SET patrol_id =?1, event_status_id =?2 where id =?3";
    @Modifying(clearAutomatically = true)
    @Query(value = update_patrol, nativeQuery = true)
    Event updatePatrol(Long patrolId, Integer eventStatusId, Long id);

    String update_work = "UPDATE events SET event_status_id = '3' WHERE id =?1";
    @Query(value = update_work, nativeQuery = true)
    Event updateWork(Long id);
}
