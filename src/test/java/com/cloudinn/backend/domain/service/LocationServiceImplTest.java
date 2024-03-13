package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.api.data.DomainEntityMapperImpl;
import com.cloudinn.backend.api.model.NewAmenityDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.Amenity;
import com.cloudinn.backend.domain.model.Location;
import com.cloudinn.backend.domain.repository.LocalityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static com.cloudinn.backend.utils.LocalityHelper.generateAmenityDto;
import static com.cloudinn.backend.utils.LocalityHelper.generateNewLocalityDto;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class LocationServiceImplTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private DomainEntityMapperImpl<NewLocationDto, OutputDto, Location> localityMapper;

    @Autowired
    private DomainEntityMapperImpl<NewAmenityDto, OutputDto, Amenity> amenityMapper;

    @BeforeEach
    void setup() {
        this.localityRepository.deleteAll();
    }

    @Test
    void create_shouldPersistLocality() {
        var newLocality = localityMapper.mapInputToEntity(generateNewLocalityDto(), Location.class);
        var result = locationService.create(newLocality);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertTrue(result.getId() >= 1L);
        assertEquals("Hotel", result.getName());
    }

    @Test
    @Transactional
    void addAmenity_shouldAddAndPersistAmenity() {
        var persistedLocality = persistDefaultLocality();
        var newAmenity = amenityMapper.mapInputToEntity(generateAmenityDto(), Amenity.class);

        locationService.addAmenity(persistedLocality.getId(), newAmenity);

        var result = localityRepository.findById(persistedLocality.getId())
                .orElseThrow();

        assertNotNull(result);
        assertTrue(result.getAmenities().size() > 0);
    }

    @Test
    @Transactional
    void removeAmenity_shouldRemoveAmenity() {
        var persistedLocality = persistDefaultLocality();
        var newAmenity = amenityMapper.mapInputToEntity(generateAmenityDto(), Amenity.class);
        locationService.addAmenity(persistedLocality.getId(), newAmenity);
        persistedLocality = localityRepository.findById(persistedLocality.getId())
                .orElseThrow();
        var amenityIdRepresentation = new Amenity();
        amenityIdRepresentation.setId(persistedLocality.getAmenities().get(0).getId());
        locationService.removeAmenity(persistedLocality.getId(), amenityIdRepresentation);

        var result = localityRepository.findById(persistedLocality.getId())
                .orElseThrow();

        assertNotNull(result.getAmenities());
        assertEquals(0, result.getAmenities().size());
    }

    private Location persistDefaultLocality() {
        return localityRepository.save(localityMapper.mapInputToEntity(generateNewLocalityDto(), Location.class));
    }


}
