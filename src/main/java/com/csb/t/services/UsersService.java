package com.csb.t.services;

import com.csb.t.dtos.SignInDTO;
import com.csb.t.dtos.SignUpDTO;
import com.csb.t.entities.Games;
import com.csb.t.entities.Users;
import com.csb.t.repositories.GamesRepository;
import com.csb.t.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private GamesRepository gamesRepository;

    public UsersService(UsersRepository uRepository, GamesRepository gRepository){
        this.usersRepository = uRepository;
        this.gamesRepository = gRepository;
    }

    public Users addOne(SignUpDTO user){
        Users newUser = new Users();

        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmailAddress());
        newUser.setDateCreated(LocalDateTime.now());
        newUser.setRoleId(1);
        newUser.setPassword(user.getPassword());

        return usersRepository.save(newUser);
    }

    public Users findOneByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public List<Games> findAllGames(){
        return gamesRepository.findAllByOrderByDatecreatedDesc();
    }

    public Users validateUser(SignInDTO user){
        Users existingUser = this.findOneByEmail(user.getEmailAddress());

        if(existingUser == null){
            return null;
        }

        if(existingUser.getPassword().equals(user.getPassword()) == false){
            return null;
        }

        return existingUser;
    }
}


