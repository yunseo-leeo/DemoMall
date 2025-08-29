package com.example.mall.mapper;

import com.example.mall.auth.Request.UserRequestDto.UserLoginRequestDto;
import com.example.mall.auth.Request.UserRequestDto.UserUpdateRequestDto;
import com.example.mall.auth.Response.UserResponseDto.UserLoginResponseDto;
import com.example.mall.auth.Response.UserResponseDto.UserUpdateResponseDto;
import com.example.mall.domain.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserLoginResponseDto ToUserLoginResponseDto(UserLoginRequestDto userLoginRequestDto);

    void toUpdateFromDto(UserUpdateRequestDto userUpdateRequestDto, @MappingTarget User user);

    UserUpdateResponseDto toUpdateDto(User user);
}
