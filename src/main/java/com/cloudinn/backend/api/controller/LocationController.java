package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.location.LocationDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;

public interface LocationController {

    LocationDto create(NewLocationDto newLocationDto);
    LocationDto update(Long id, NewLocationDto updateLocationDto);
    LocationDto get(Long id);
    void delete(Long id);

}
