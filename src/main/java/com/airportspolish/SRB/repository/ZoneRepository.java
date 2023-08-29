/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

    String zap_search = "SELECT * FROM tab_zone where zone_active = true and zone_name iLIKE %?1%";
    @Query(value = zap_search, nativeQuery = true)
    List<Zone> getSearch(String zoneName);
}
