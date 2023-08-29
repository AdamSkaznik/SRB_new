/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Temp {
    @Transient
    private Long tempEventId;
    @Transient
    private String tempReporting;
    @Transient
    private String tempDesc;
    @Transient
    private Long tempCategoryId;
    @Transient
    private Long tempZoneId;
    @Transient
    private Long tempPlaceId;
    @Transient
    private Long tempLevelId;
    @Transient
    private int tempPatrolId;








}
