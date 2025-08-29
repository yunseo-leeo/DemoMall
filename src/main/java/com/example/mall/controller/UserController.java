package com.example.mall.controller;

import com.example.mall.auth.Request.UserRequestDto.UserLoginRequestDto;
import com.example.mall.auth.Request.UserRequestDto.UserSignRequestDto;
import com.example.mall.auth.Response.UserResponseDto.UserLoginResponseDto;
import com.example.mall.auth.Response.UserResponseDto.UserSignResponseDto;
import com.example.mall.service.ServiceClass.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserSignResponseDto> registerUser(
            @Valid @RequestBody UserSignRequestDto userSignRequestDto){
        UserSignResponseDto responseDto = userService.RegisterUser(userSignRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody @Valid UserLoginRequestDto dto) {
        UserLoginResponseDto response = userService.LoginUser(dto);
        return ResponseEntity.ok(response);
    }

}
