/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.Instructions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionsRepository extends JpaRepository<Instructions, Long> {
    String zap = "SELECT * FROM instructions WHERE event_id = ?1";
    @Query(value = zap, nativeQuery = true)
    List<Instructions> getByEventId(Long evenId);
}
