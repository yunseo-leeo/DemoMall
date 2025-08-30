package com.example.mall.auth.Response.UserResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserSignResponseDto {
    @JsonProperty("userId")
    private final Long id;

    private final String userName;
    private final String email;
    private final String successMessage;

}
