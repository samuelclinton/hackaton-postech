package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewBuildingDto implements InputDto {

    @Schema(example = "Prédio principal")
    private String description;

}
