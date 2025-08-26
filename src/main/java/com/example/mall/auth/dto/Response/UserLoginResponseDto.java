package com.example.mall.auth.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDto {

    @JsonProperty("userId")
    private Long id;

    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;
}
