package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.data.DomainEntityMapperImpl;
import com.cloudinn.backend.api.model.NewOptionalDto;
import com.cloudinn.backend.api.model.OptionalDto;
import com.cloudinn.backend.api.model.location.LocationDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.model.Optional;
import com.cloudinn.backend.domain.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations/{locationId}/optionals")
public class LocationOptionalControllerImpl implements LocationOptionalController {

    private final LocationService locationService;
    private final DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper;
    private final DomainEntityMapperImpl<NewOptionalDto, OptionalDto, Optional> optionalMapper;

    public LocationOptionalControllerImpl(LocationService locationService,
                                          DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper,
                                          DomainEntityMapperImpl<NewOptionalDto, OptionalDto, Optional> optionalMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
        this.optionalMapper = optionalMapper;
    }

    @Override
    @PostMapping
    @Transactional
    public LocationDto addOptional(@PathVariable Long locationId, @RequestBody @Valid  NewOptionalDto newOptionalDto) {
        locationService.addOptional(locationId, optionalMapper.mapInputToEntity(newOptionalDto, Optional.class));
        return locationMapper.mapEntityToOutput(locationService.get(locationId), LocationDto.class);
    }

    @Override
    @DeleteMapping("/{optionalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public LocationDto removeOptional(@PathVariable Long locationId, @PathVariable Long optionalId) {
        Optional removedOptionalRepresentation = new Optional();
        removedOptionalRepresentation.setId(optionalId);
        locationService.removeOptional(locationId, removedOptionalRepresentation);
        return locationMapper.mapEntityToOutput(locationService.get(locationId), LocationDto.class);
    }

}
