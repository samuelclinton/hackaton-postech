package com.cloudinn.backend.api.model.location;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.api.model.AmenityDto;
import com.cloudinn.backend.api.model.BuildingDto;
import com.cloudinn.backend.api.model.OptionalDto;
import com.cloudinn.backend.domain.data.OutputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema
public class LocationDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Hotel Zimbábue")
    private String name;

    private AddressDto address;
    private List<AmenityDto> amenities;
    private List<OptionalDto> optionals;
    private List<BuildingDto> buildings;

}
