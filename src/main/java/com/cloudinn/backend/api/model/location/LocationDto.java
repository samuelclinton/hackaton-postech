package com.cloudinn.backend.api.model.location;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.api.model.AmenityDto;
import com.cloudinn.backend.api.model.BuildingDto;
import com.cloudinn.backend.api.model.OptionalDto;
import com.cloudinn.backend.domain.data.OutputDto;
import lombok.Data;

import java.util.List;

@Data
public class LocationDto implements OutputDto {

    private Long id;
    private String name;
    private AddressDto address;
    private List<AmenityDto> amenities;
    private List<OptionalDto> optionals;
    private List<BuildingDto> buildings;

}
