/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service.impl;

import com.airportspolish.SRB.model.Place;
import com.airportspolish.SRB.repository.PlaceRepository;
import com.airportspolish.SRB.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<Place> getAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place getById(Long id) {
        return placeRepository.getReferenceById(id);
    }

    @Override
    public void savePlace(Place place) {
    placeRepository.save(place);
    }

    @Override
    public List<Place> getSearch(String placeName) {
        return placeRepository.getSearch(placeName);
    }
}
