package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.api.model.IdRepresentationDto;
import com.cloudinn.backend.domain.model.RoomType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewRoomDto implements RoomInputDto {

    @NotNull
    private RoomType type;

    @NotNull
    @Positive
    @Schema(example = "2")
    private Integer guestCapacity;

    @NotNull
    @Positive
    @Schema(example = "1")
    private Integer bedAmount;

    @NotBlank
    @Schema(example = "Cama Queen-size")
    private String bedType;

    @NotBlank
    @Schema(example = "Banheiro completo com ducha")
    private String bathroom;

    @Positive
    @Schema(example = "249.90")
    private BigDecimal price;

    @NotNull
    @Valid
    private IdRepresentationDto building;

    @NotNull
    @Valid
    private IdRepresentationDto location;

}
