package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.BuildingDto;
import com.cloudinn.backend.api.model.NewBuildingDto;
import com.cloudinn.backend.api.model.location.LocationDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;
import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.domain.model.Building;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations/{locationId}/buildings")
public class LocationBuildingControllerImpl implements LocationBuildingController {

    private final LocationService locationService;
    private final DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper;
    private final DomainEntityMapperImpl<NewBuildingDto, BuildingDto, Building> buildingMapper;

    public LocationBuildingControllerImpl(LocationService locationService,
                                          DomainEntityMapperImpl<NewLocationDto, LocationDto, Location> locationMapper,
                                          DomainEntityMapperImpl<NewBuildingDto, BuildingDto, Building> buildingMapper) {
        this.locationService = locationService;
        this.locationMapper = locationMapper;
        this.buildingMapper = buildingMapper;
    }

    @Override
    @PostMapping
    @Transactional
    public LocationDto addBuilding(@PathVariable Long locationId, @RequestBody @Valid  NewBuildingDto newBuildingDto) {
        locationService.addBuilding(locationId, buildingMapper.mapInputToEntity(newBuildingDto, Building.class));
        return locationMapper.mapEntityToOutput(locationService.get(locationId), LocationDto.class);
    }

    @Override
    @DeleteMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public LocationDto removeBuilding(@PathVariable Long locationId, @PathVariable Long buildingId) {
        Building removedBuildingRepresentation = new Building();
        removedBuildingRepresentation.setId(buildingId);
        locationService.removeBuilding(locationId, removedBuildingRepresentation);
        return locationMapper.mapEntityToOutput(locationService.get(locationId), LocationDto.class);
    }

}
