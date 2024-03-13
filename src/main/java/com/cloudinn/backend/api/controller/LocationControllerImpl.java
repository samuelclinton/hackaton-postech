package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.data.DomainEntityMapperImpl;
import com.cloudinn.backend.api.model.location.LocationDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationControllerImpl implements LocationController {

    private final LocationService locationService;
    private final DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper;

    public LocationControllerImpl(LocationService locationService,
                                  DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDto create(@RequestBody @Valid NewLocationDto newLocationDto) {
        Location createdLocation = locationService
                .create(locationMapper.mapInputToEntity(newLocationDto, Location.class));
        return locationMapper.mapEntityToOutput(createdLocation, LocationDto.class);
    }

    @Override
    @PutMapping("/{id}")
    @Transactional
    public LocationDto update(@PathVariable Long id, @RequestBody @Valid NewLocationDto updateLocationDto) {
        Location updatedLocation = locationMapper.mapInputToEntity(updateLocationDto, Location.class);
        return locationMapper.mapEntityToOutput(locationService.update(id, updatedLocation), LocationDto.class);
    }

    @Override
    @GetMapping("/{id}")
    @Transactional
    public LocationDto get(@PathVariable Long id) {
        return locationMapper.mapEntityToOutput(locationService.get(id), LocationDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        locationService.delete(id);
    }

}
