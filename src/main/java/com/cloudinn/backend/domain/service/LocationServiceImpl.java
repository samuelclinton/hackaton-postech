package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.exception.LocalityNotFoundException;
import com.cloudinn.backend.domain.model.Amenity;
import com.cloudinn.backend.domain.model.Building;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.model.Optional;
import com.cloudinn.backend.domain.repository.LocalityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocalityRepository localityRepository;

    public LocationServiceImpl(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    @Override
    @Transactional
    public Location create(Location location) {
        return localityRepository.save(location);
    }

    @Override
    @Transactional
    public Location update(Long id, Location updatedLocation) {
        Location exixtingLocation = get(id);
        BeanUtils.copyProperties(updatedLocation, exixtingLocation, "id");
        return localityRepository.save(exixtingLocation);
    }

    @Override
    public Location get(Long id) {
        return localityRepository.findById(id)
                .orElseThrow(() -> new LocalityNotFoundException("Nenhuma localidade encontrada com o id " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        localityRepository.delete(get(id));
    }

    @Override
    @Transactional
    public void addAmenity(Long localityId, Amenity amenity) {
        Location existingLocation = get(localityId);
        existingLocation.addAmenity(amenity);
        localityRepository.saveAndFlush(existingLocation);
    }

    @Override
    @Transactional
    public void removeAmenity(Long localityId, Amenity amenity) {
        Location existingLocation = get(localityId);
        existingLocation.removeAmenity(amenity);
        localityRepository.saveAndFlush(existingLocation);
    }

    @Override
    @Transactional
    public void addOptional(Long localityId, Optional optional) {
        Location existingLocation = get(localityId);
        existingLocation.addOptional(optional);
        localityRepository.saveAndFlush(existingLocation);
    }

    @Override
    @Transactional
    public void removeOptional(Long localityId, Optional optional) {
        Location existingLocation = get(localityId);
        existingLocation.removeOptional(optional);
        localityRepository.saveAndFlush(existingLocation);
    }

    @Override
    @Transactional
    public void addBuilding(Long localityId, Building building) {
        Location existingLocation = get(localityId);
        existingLocation.addBuilding(building);
        localityRepository.saveAndFlush(existingLocation);
    }

    @Override
    @Transactional
    public void removeBuilding(Long localityId, Building building) {
        Location existingLocation = get(localityId);
        existingLocation.removeBuilding(building);
        localityRepository.saveAndFlush(existingLocation);
    }

}
