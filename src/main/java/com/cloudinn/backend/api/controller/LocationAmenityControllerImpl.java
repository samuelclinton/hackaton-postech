package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.api.model.AmenityDto;
import com.cloudinn.backend.api.model.NewAmenityDto;
import com.cloudinn.backend.api.model.location.LocationDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;
import com.cloudinn.backend.domain.model.Amenity;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations/{locationId}/amenities")
public class LocationAmenityControllerImpl implements LocationAmenityController {

    private final LocationService locationService;
    private final DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper;
    private final DomainEntityMapperImpl<NewAmenityDto, AmenityDto, Amenity> amenityMapper;

    public LocationAmenityControllerImpl(LocationService locationService,
                                         DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper,
                                         DomainEntityMapperImpl<NewAmenityDto, AmenityDto, Amenity> amenityMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
        this.amenityMapper = amenityMapper;
    }

    @Override
    @PostMapping
    @Transactional
    public LocationDto addAmenity(@PathVariable Long locationId, @RequestBody @Valid NewAmenityDto newAmenityDto) {
        locationService.addAmenity(locationId, amenityMapper.mapInputToEntity(newAmenityDto, Amenity.class));
        return locationMapper.mapEntityToOutput(locationService.get(locationId), LocationDto.class);
    }

    @Override
    @DeleteMapping("/{amenityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public LocationDto removeAmenity(@PathVariable Long locationId, @PathVariable Long amenityId) {
        Amenity amenityToBeRemoved = new Amenity();
        amenityToBeRemoved.setId(amenityId);
        locationService.removeAmenity(locationId, amenityToBeRemoved);
        return locationMapper.mapEntityToOutput(locationService.get(locationId), LocationDto.class);
    }

}
