package com.csb.t.services;

import com.csb.t.dtos.SaveGameDTO;
import com.csb.t.entities.Games;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
    public Games addOne(SaveGameDTO game) {
        Games newGame = new Games();

        return newGame;
    }
}
