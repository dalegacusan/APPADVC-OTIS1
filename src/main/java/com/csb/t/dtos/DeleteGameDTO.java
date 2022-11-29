package com.csb.t.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class DeleteGameDTO {
    public Long getGameid() {
        return gameid;
    }

    public void setGameid(Long gameid) {
        this.gameid = gameid;
    }

    @Min(value = 1, message = "Game ID must be at least 1")
    @Positive(message = "Invalid Game ID")
    private Long gameid;
}
