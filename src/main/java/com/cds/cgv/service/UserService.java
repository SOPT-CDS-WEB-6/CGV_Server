package com.cds.cgv.service;

import com.cds.cgv.controller.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUserProfile(Long userNumber);
}
