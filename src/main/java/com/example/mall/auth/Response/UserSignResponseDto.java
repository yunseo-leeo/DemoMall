package com.example.mall.auth.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserSignResponseDto {
    @JsonProperty("userId")
    private final Long id;

    private final String userName;
    private final String email;
    private final String successMessage;

}
