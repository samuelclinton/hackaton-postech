package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.domain.data.OutputDto;
import lombok.Data;

@Data
public class FurnitureDto implements OutputDto {

    private Long id;
    private Integer amount;
    private String description;

}
