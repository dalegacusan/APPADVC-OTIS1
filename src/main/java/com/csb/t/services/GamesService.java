package com.csb.t.services;

import com.csb.t.dtos.SaveGameDTO;
import com.csb.t.entities.Games;
import com.csb.t.entities.Users;
import com.csb.t.repositories.GamesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        newGame.setDatecreated(LocalDateTime.now());

        Users testUser = new Users();
        testUser.setUserid(Long.parseLong("11"));

        newGame.setUsers(testUser);

        return gamesRepository.save(newGame);
    }

    public List<Games> findAllByUser(Users users){
        return gamesRepository.findAllByUsersOrderByDatecreatedDesc(users);
    }

    public List<Games> findAllForLeaderboard(){
        return gamesRepository.findTop10ByOrderByScoreDesc();
    }
}
