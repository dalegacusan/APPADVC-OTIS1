package com.csb.t.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveGameDTO {
    @Min(value = 1, message = "Score must be at least 1")
    @Positive(message = "Invalid score")
    private int score;

    @Min(value = 1, message = "Round must be at least 1")
    @Positive(message = "Invalid round")
    private int round;
}
