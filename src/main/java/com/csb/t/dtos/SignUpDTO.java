package com.csb.t.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class SignUpDTO {
    @NotBlank(message = "Username is required.")
    @Length(min = 4, message = "Username must be at least {min} characters")
    @Length(max = 50, message = "Username must be equal to or less than {max} characters")
    private String username;

    @NotBlank(message = "Email Address is required.")
    @Email(message = "Please enter a valid email address.")
    @Length(min = 6, message = "Email Address must be at least {min} characters")
    @Length(max = 200, message = "Email Address must be equal to or less than {max} characters")
    private String emailAddress;

    @NotBlank(message = "Password is required.")
    @Length(min = 6, message = "Password must be at least {min} characters")
    @Length(max = 20, message = "Password must be equal to or less than {max} characters")
    private String password;
}
