package com.csb.t.dtos;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class SignInDTO {
    @Email(message = "Please enter a valid email address.")
    @Length(min = 6, message = "Email Address must be at least {min} characters")
    @Length(max = 200, message = "Email Address must be equal to or less than {max} characters")
    private String emailAddress;

    @Length(min = 6, message = "Password must be at least {min} characters")
    @Length(max = 20, message = "Password must be equal to or less than {max} characters")
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
