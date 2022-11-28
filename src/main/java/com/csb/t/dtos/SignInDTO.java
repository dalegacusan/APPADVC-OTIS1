package com.csb.t.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class SignInDTO {
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

    @NotBlank(message = "Email Address is required.")
    @Email(message = "Please enter a valid email address.")
    @Length(min = 6, message = "Email Address must be at least {min} characters")
    @Length(max = 200, message = "Email Address must be equal to or less than {max} characters")
    private String emailAddress;

    @NotBlank(message = "Password is required.")
    private String password;
}
