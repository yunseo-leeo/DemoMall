package com.example.mall.service.ServiceClass;

import com.example.mall.auth.Request.UserRequestDto.UserUpdateRequestDto;
import com.example.mall.auth.Response.UserResponseDto.UserUpdateResponseDto;
import com.example.mall.domain.Entity.User;
import com.example.mall.mapper.UserMapper;
import com.example.mall.security.JwtTokenProvider;
import com.example.mall.auth.Request.UserRequestDto.UserLoginRequestDto;
import com.example.mall.auth.Request.UserRequestDto.UserSignRequestDto;
import com.example.mall.auth.Response.UserResponseDto.UserLoginResponseDto;
import com.example.mall.auth.Response.UserResponseDto.UserSignResponseDto;
import com.example.mall.mapper.UserSignMapper;
import com.example.mall.service.ServiceInterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.mall.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserSignMapper userSignMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserSignResponseDto RegisterUser(UserSignRequestDto userSignRequestDto){

        if(userRepository.existsByEmail(userSignRequestDto.getEmail())){
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        if(userRepository.existsByUserName(userSignRequestDto.getUserName())){
            throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
        }

        User user = userSignMapper.ToEntity(userSignRequestDto);

        User savedUser = userRepository.save(user);

        return userSignMapper.ToUserSignResponseDto(savedUser);
    }

    @Override
    public UserLoginResponseDto LoginUser(UserLoginRequestDto userLoginRequestDto) {

        User user = userRepository.findByEmail(userLoginRequestDto.getEmail())
                .orElseThrow(() ->new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(userLoginRequestDto.getPassword(), user.getPassword())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = jwtTokenProvider.createAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getEmail());

        return UserLoginResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getEmail())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public UserUpdateResponseDto UpdateUser(Long id, UserUpdateRequestDto userUpdateRequestDto){

        User user = userRepository.findById(id)
                .orElseThrow(() ->new UsernameNotFoundException("사용자 정보가 존재하지 않습니다."));

        userMapper.toUpdateFromDto(userUpdateRequestDto, user);

        return userMapper.toUpdateDto(user);
    }





}

