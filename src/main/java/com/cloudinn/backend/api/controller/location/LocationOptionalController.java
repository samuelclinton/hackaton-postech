package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.NewOptionalDto;
import com.cloudinn.backend.api.model.location.LocationDto;

public interface LocationOptionalController {

    LocationDto addOptional(Long locationId, NewOptionalDto newOptionalDto);
    LocationDto removeOptional(Long locationId, Long optionalId);

}
