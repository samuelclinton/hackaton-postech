package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.NewBuildingDto;
import com.cloudinn.backend.api.model.location.LocationDto;

public interface LocationBuildingController {

    LocationDto addBuilding(Long locationId, NewBuildingDto newBuildingDto);
    LocationDto removeBuilding(Long locationId, Long buildingId);

}
