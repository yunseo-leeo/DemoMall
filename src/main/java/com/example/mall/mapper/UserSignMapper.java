package com.example.mall.mapper;

import com.example.mall.domain.Entity.User;
import com.example.mall.auth.dto.Request.UserSignRequestDto;
import com.example.mall.auth.dto.Response.UserSignResponseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserSignMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "password", ignore = true)
    public abstract User ToEntity(UserSignRequestDto userSignRequestDto);

    public abstract UserSignResponseDto ToUserSignResponseDto(User user);

    @AfterMapping
    protected void EncodedPassword(@MappingTarget User ToEntity, UserSignRequestDto userSignRequestDto) {
        ToEntity.setPassword(passwordEncoder.encode(userSignRequestDto.getPassword()));
    }

}
