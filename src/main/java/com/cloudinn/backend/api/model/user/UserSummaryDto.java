package com.cloudinn.backend.api.model.user;

import com.cloudinn.backend.domain.data.OutputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserSummaryDto implements OutputDto {

    @Schema(example = "1")
    private String id;

    @Schema(example = "João das Neves")
    private String name;

    @Schema(example = "email@email.com")
    private String email;

}
