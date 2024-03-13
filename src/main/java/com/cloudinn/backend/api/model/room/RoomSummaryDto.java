package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.api.model.location.LocationSummaryDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.RoomType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomSummaryDto implements OutputDto {

    private Long id;
    private RoomType type;
    private Integer guestCapacity;
    private Integer bedAmount;
    private String bedType;
    private BigDecimal price;
    private LocationSummaryDto location;

}
