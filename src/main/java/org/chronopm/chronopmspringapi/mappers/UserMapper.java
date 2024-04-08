package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.UserDto;
import org.chronopm.chronopmspringapi.models.User;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .familyName(user.getFamilyName())
                .surname(user.getSurname())
                .introduction(user.getIntroduction())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .projectIds(user.getProjectIds())
                .noteIds(user.getNoteIds())
                .issueIds(user.getIssueIds())
                .commentIds(user.getCommentIds())
                .build();
    }

    public static User mapToModel(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .familyName(dto.getFamilyName())
                .surname(dto.getSurname())
                .introduction(dto.getIntroduction())
                .phoneNumber(dto.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .projectIds(dto.getProjectIds())
                .noteIds(dto.getNoteIds())
                .issueIds(dto.getIssueIds())
                .commentIds(dto.getCommentIds())
                .build();
    }

    public static User mapForUpdate(UserDto updateDto) {
        return User.builder()
                .email(updateDto.getEmail())
                .username(updateDto.getUsername())
                .familyName(updateDto.getFamilyName())
                .surname(updateDto.getSurname())
                .introduction(updateDto.getIntroduction())
                .phoneNumber(updateDto.getPhoneNumber())
                .updatedAt(LocalDateTime.now())
                .projectIds(updateDto.getProjectIds())
                .noteIds(updateDto.getNoteIds())
                .issueIds(updateDto.getIssueIds())
                .commentIds(updateDto.getCommentIds())
                .build();
    }
}
