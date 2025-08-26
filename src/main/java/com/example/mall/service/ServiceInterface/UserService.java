package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.dto.Request.UserLoginRequestDto;
import com.example.mall.auth.dto.Request.UserSignRequestDto;
import com.example.mall.auth.dto.Response.UserLoginResponseDto;
import com.example.mall.auth.dto.Response.UserSignResponseDto;

public interface UserService {

    UserSignResponseDto RegisterUser(UserSignRequestDto userSignRequestDto);
    UserLoginResponseDto LoginUser(UserLoginRequestDto userLoginRequestDto);
}
