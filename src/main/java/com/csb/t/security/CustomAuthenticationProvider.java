package com.csb.t.security;

import com.csb.t.dtos.SignInDTO;
import com.csb.t.entities.Users;
import com.csb.t.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UsersService usersService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String emailAddress = authentication.getName();
        String password = authentication.getCredentials().toString();

        SignInDTO tempUser = new SignInDTO();
        tempUser.setEmailAddress(emailAddress);
        tempUser.setPassword(password);

        Users existingUser = usersService.validateUser(tempUser);

        if(existingUser != null){
            int roleId = existingUser.getRoleId();

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    existingUser,
                    password,
                    Arrays.asList(new SimpleGrantedAuthority(Integer.toString(roleId)))
            );

            return token;
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
