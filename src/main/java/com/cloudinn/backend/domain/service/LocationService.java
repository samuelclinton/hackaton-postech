package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.model.Amenity;
import com.cloudinn.backend.domain.model.Building;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.model.Optional;

public interface LocationService {

    Location create(Location location);
    Location update(Long id, Location updatedLocation);
    Location get(Long id);
    void delete(Long id);
    void addAmenity(Long localityId, Amenity amenity);
    void removeAmenity(Long localityId, Amenity amenity);
    void addOptional(Long localityId, Optional optional);
    void removeOptional(Long localityId, Optional optional);
    void addBuilding(Long localityId, Building building);
    void removeBuilding(Long localityId, Building building);

}
