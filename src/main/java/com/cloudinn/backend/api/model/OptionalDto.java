package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.OptionalType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionalDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    private OptionalType type;

    @Schema(example = "Cesta de café da manhã")
    private String description;

    @Schema(example = "49.90")
    private BigDecimal price;

}
