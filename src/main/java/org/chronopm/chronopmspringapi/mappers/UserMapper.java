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
                .projectId(user.getProjectId())
                .noteId(user.getNoteId())
                .issueId(user.getIssueId())
                .commentId(user.getCommentId())
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
                .projectId(dto.getProjectId())
                .noteId(dto.getNoteId())
                .issueId(dto.getIssueId())
                .commentId(dto.getCommentId())
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
                .projectId(updateDto.getProjectId())
                .noteId(updateDto.getNoteId())
                .issueId(updateDto.getIssueId())
                .commentId(updateDto.getCommentId())
                .build();
    }
}
