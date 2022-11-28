package com.csb.t.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.*;

public class SignUpDTO {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Username is required.")
    @Length(min = 4, message = "Username must be at least {min} characters")
    @Length(max = 50, message = "Username must be equal to or less than {max} characters")
    private String username;

    @Email(message = "Please enter a valid email address.")
    @Length(min = 6, message = "Email Address must be at least {min} characters")
    @Length(max = 200, message = "Email Address must be equal to or less than {max} characters")
    private String emailAddress;

    @Length(min = 6, message = "Password must be at least {min} characters")
    @Length(max = 20, message = "Password must be equal to or less than {max} characters")
    private String password;
}
