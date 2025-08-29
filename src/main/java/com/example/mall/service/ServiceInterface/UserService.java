package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.Request.UserRequestDto.UserLoginRequestDto;
import com.example.mall.auth.Request.UserRequestDto.UserSignRequestDto;
import com.example.mall.auth.Response.UserResponseDto.UserLoginResponseDto;
import com.example.mall.auth.Response.UserResponseDto.UserSignResponseDto;

public interface UserService {

    UserSignResponseDto RegisterUser(UserSignRequestDto userSignRequestDto);
    UserLoginResponseDto LoginUser(UserLoginRequestDto userLoginRequestDto);
}
