package com.csb.t.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteGameDTO {
    @Min(value = 1, message = "Game ID must be at least 1")
    @Positive(message = "Invalid Game ID")
    private Long gameid;
}
