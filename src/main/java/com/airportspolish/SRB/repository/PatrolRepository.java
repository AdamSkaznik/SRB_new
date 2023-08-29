/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.Patrol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrolRepository extends JpaRepository<Patrol, Integer> {

    String zap_search = "SELECT * FROM tab_patrol WHERE patrol_active = true AND patrol_name iLIKE %?1%";
    @Query(value = zap_search, nativeQuery = true)
    List<Patrol> getByName(String patrolName);
}
