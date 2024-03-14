package com.cloudinn.backend.api.model.user;

import com.cloudinn.backend.domain.data.OutputDto;
import lombok.Data;

@Data
public class UserSummaryDto implements OutputDto {

    private String id;
    private String name;
    private String email;

}
