package com.cloudinn.backend.domain.model;

import com.cloudinn.backend.domain.data.DomainEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Location implements DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Amenity> amenities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Building> buildings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Optional> optionals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Room> rooms = new ArrayList<>();

    public void addAmenity(Amenity amenity) {
        this.amenities.add(amenity);
    }

    public void removeAmenity(Amenity amenity) {
        this.amenities.remove(amenity);
    }

    public void addOptional(Optional optional) {
        this.optionals.add(optional);
    }

    public void removeOptional(Optional optional) {
        this.optionals.remove(optional);
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }

    public void removeBuilding(Building building) {
        this.buildings.remove(building);
    }

}
