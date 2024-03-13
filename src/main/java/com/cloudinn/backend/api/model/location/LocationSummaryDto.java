package com.cloudinn.backend.api.model.location;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.data.OutputDto;
import lombok.Data;

@Data
public class LocationSummaryDto implements OutputDto {

    private Long id;
    private String name;
    private AddressDto address;

}
