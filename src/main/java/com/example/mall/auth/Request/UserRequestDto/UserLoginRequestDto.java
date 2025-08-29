package com.example.mall.auth.Request.UserRequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
