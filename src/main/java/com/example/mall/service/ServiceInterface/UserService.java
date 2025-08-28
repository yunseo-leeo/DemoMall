package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.Request.UserLoginRequestDto;
import com.example.mall.auth.Request.UserSignRequestDto;
import com.example.mall.auth.Response.UserLoginResponseDto;
import com.example.mall.auth.Response.UserSignResponseDto;

public interface UserService {

    UserSignResponseDto RegisterUser(UserSignRequestDto userSignRequestDto);
    UserLoginResponseDto LoginUser(UserLoginRequestDto userLoginRequestDto);
}
