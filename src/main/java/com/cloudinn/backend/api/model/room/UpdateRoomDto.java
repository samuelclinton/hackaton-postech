package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.domain.model.RoomType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateRoomDto implements RoomInputDto {

    private RoomType type;

    @Positive
    @Schema(example = "2")
    private Integer guestCapacity;

    @Positive
    @Schema(example = "1")
    private Integer bedAmount;

    @Schema(example = "Cama Queen-size")
    private String bedType;

    @Schema(example = "Banheiro completo com ducha")
    private String bathroom;

    @Positive
    @Schema(example = "249.90")
    private BigDecimal price;

}
