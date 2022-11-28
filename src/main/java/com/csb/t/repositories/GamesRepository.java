package com.csb.t.repositories;

import com.csb.t.entities.Games;
import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Games, Long> {
}
