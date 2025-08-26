package com.example.mall.mapper;

import com.example.mall.auth.dto.Request.UserLoginRequestDto;
import com.example.mall.auth.dto.Response.UserLoginResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserLoginMapper {
    UserLoginResponseDto ToUserLoginResponseDto(UserLoginRequestDto userLoginRequestDto);
}
