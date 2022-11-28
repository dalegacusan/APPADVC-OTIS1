package com.csb.t.services;

import com.csb.t.dtos.SignUpDTO;
import com.csb.t.entities.Users;
import com.csb.t.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    public UsersService(UsersRepository uRepository){
        this.usersRepository = uRepository;
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
}


