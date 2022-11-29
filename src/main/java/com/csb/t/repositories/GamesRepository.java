package com.csb.t.repositories;

import com.csb.t.entities.Games;
import com.csb.t.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends CrudRepository<Games, Long> {
    List<Games> findAllByUsersOrderByDatecreatedDesc(Users users);

    List<Games> findTop10ByOrderByScoreDesc();
}
