package com.csb.t.services;

import com.csb.t.dtos.SaveGameDTO;
import com.csb.t.entities.Games;
import com.csb.t.entities.Users;
import com.csb.t.repositories.GamesRepository;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
    private GamesRepository gamesRepository;

    public GamesService(GamesRepository gRepository){
        this.gamesRepository = gRepository;
    }

    public Games addOne(SaveGameDTO game) {
        Games newGame = new Games();
        newGame.setScore(game.getScore());
        newGame.setRound(game.getRound());

        Users testUser = new Users();
        testUser.setUserid(Long.parseLong("11"));

        newGame.setUsers(testUser);

        return gamesRepository.save(newGame);
    }
}
