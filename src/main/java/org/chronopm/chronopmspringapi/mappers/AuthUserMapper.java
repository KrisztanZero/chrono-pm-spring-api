package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.AuthUserDto;
import org.chronopm.chronopmspringapi.models.AuthUser;

import java.time.LocalDateTime;

public class AuthUserMapper {
    public static AuthUserDto mapToDto(AuthUser authUser) {
        return AuthUserDto.builder()
                .id(authUser.getId())
                .userId(authUser.getUserId())
                .username(authUser.getUsername())
                .password(authUser.getPassword())
                .createdAt(authUser.getCreatedAt())
                .updatedAt(authUser.getUpdatedAt())
                .build();
    }

    public static AuthUser mapToModel(AuthUserDto dto) {
        return AuthUser.builder()
                .createdAt(LocalDateTime.now())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }

    public static AuthUser mapForUpdate(AuthUserDto updateDto) {
        return AuthUser.builder()
                .updatedAt(LocalDateTime.now())
                .username(updateDto.getUsername())
                .password(updateDto.getPassword())
                .build();
    }
}
