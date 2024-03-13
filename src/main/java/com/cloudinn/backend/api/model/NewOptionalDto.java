package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import com.cloudinn.backend.domain.model.OptionalType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class NewOptionalDto implements InputDto {

    private OptionalType type;
    private String description;
    private BigDecimal price;

}
