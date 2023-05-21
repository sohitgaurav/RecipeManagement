package com.geekster.recipe.Management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {
    @NotBlank(message = "Email cannot be blank")
    @Email
    private String UserEmail;

    @NotEmpty
    private String UserPassword;
}
