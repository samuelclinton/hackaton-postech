package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewBuildingDto implements InputDto {

    private String description;

}
