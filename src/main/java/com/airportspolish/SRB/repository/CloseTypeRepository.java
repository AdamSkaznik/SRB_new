/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.CloseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloseTypeRepository extends JpaRepository<CloseType, Integer> {

    String zap_search = "SELECT * FROM tab_close_type WHERE active = true and close_type_name iLike %?1%";
    @Query(value = zap_search, nativeQuery = true)
    List<CloseType> searchCloseType(String closeTypeName);
}
