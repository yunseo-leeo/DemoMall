package com.example.mall.mapper;

import com.example.mall.auth.Request.UserRequestDto.UserLoginRequestDto;
import com.example.mall.auth.Response.UserResponseDto.UserLoginResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserLoginResponseDto ToUserLoginResponseDto(UserLoginRequestDto userLoginRequestDto);
}
