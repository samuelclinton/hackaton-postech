package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.OptionalType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OptionalDto implements OutputDto {

    private Long id;
    private OptionalType type;
    private String description;
    private BigDecimal price;

}
