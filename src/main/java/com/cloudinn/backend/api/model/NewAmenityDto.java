package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewAmenityDto implements InputDto {

    private Integer amount;
    private String description;

}
