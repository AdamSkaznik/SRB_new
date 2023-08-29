/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAll();
    Place getById(Long id);
    void savePlace(Place place);
    List<Place> getSearch(String placeName);
}
