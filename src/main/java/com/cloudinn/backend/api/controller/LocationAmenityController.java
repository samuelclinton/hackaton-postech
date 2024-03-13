package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.NewAmenityDto;
import com.cloudinn.backend.api.model.location.LocationDto;

public interface LocationAmenityController {

    LocationDto addAmenity(Long locationId, NewAmenityDto newAmenityDto);
    LocationDto removeAmenity(Long locationId, Long amenityId);

}
