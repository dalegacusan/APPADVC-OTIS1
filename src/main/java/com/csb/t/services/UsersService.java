package com.csb.t.services;

import com.csb.t.dtos.SignInDTO;
import com.csb.t.dtos.SignUpDTO;
import com.csb.t.entities.Users;
import com.csb.t.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsersService {
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return usersRepository.save(newUser);
    }

    public Users findOneByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public Users validateUser(SignInDTO user){
        Users existingUser = this.findOneByEmail(user.getEmailAddress());

        if(existingUser != null){
            if(passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
                return existingUser;
            }
        }

        return null;
    }
}


