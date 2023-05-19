package com.cds.cgv.service.impl;

import com.cds.cgv.controller.dto.response.UserResponseDTO;
import com.cds.cgv.infrastructure.UserRepository;
import com.cds.cgv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserResponseDTO getUserProfile(Long userNumber) {
        return UserResponseDTO.from(userRepository.getUserByUserNumber(userNumber));
    }

}
