package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.OutputDto;
import lombok.Data;

@Data
public class BuildingDto implements OutputDto {

    private Long id;
    private String description;

}
