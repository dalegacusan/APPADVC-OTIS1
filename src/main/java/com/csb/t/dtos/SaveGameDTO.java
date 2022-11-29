package com.csb.t.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class SaveGameDTO {
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @NotBlank(message = "Score is required.")
    @Min(value = 1, message = "Score must be at least 1")
    @Positive(message = "Invalid score")
    private int score;

    @NotBlank(message = "Round is required.")
    @Positive(message = "Invalid round")
    private int round;
}
