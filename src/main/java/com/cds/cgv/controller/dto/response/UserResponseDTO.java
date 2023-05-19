package com.cds.cgv.controller.dto.response;

import com.cds.cgv.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDTO {
    private final Long userNumber;
    private final String userName;
    private final String email;
    private final String phoneNumber;

    public static UserResponseDTO from(User user){
        return UserResponseDTO.builder()
                .userNumber(user.getUserNumber())
                .userName(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}
