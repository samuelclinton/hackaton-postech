package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmenityIdDto implements InputDto {

    private Long id;

}
