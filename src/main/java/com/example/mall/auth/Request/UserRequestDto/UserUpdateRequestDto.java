package com.example.mall.auth.Request.UserRequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {

    @Size(min = 2, max = 10, message = "닉네임은 최소 2자 이상, 최대 10자 이하여야 합니다.")
    @Pattern( regexp = "^[a-z0-9]+$", message = "닉네임은 영문 소문자와 숫자로만 작성해주세요.")
    private String userName;

    @Size(min = 8, max = 15, message = "비밀번호는 최소 8자 이상, 최대 15자 이하여야 합니다.")
    @Pattern( regexp = "^[a-z0-9A-Z]+$", message = "비밀번호는 영문과 숫자로만 작성해주세요.")
    private String password;

    @Email(message = "이메일을 형식에 맞게 작성해주세요.")
    private String email;
}
