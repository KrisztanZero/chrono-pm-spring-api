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

    public static User mapForUpdate(UserDto updateDto, User user) {
        return User.builder()
                .id(user.getId())
                .email(updateDto.getEmail() != null ? updateDto.getEmail() : user.getEmail())
                .username(updateDto.getUsername() != null ? updateDto.getUsername() : user.getUsername())
                .familyName(updateDto.getFamilyName() != null ? updateDto.getFamilyName() : user.getFamilyName())
                .surname(updateDto.getSurname() != null ? updateDto.getSurname() : user.getSurname())
                .introduction(updateDto.getIntroduction() != null ? updateDto.getIntroduction() : user.getIntroduction())
                .phoneNumber(updateDto.getPhoneNumber() != null ? updateDto.getPhoneNumber() : user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .projectIds(updateDto.getProjectIds() != null ? updateDto.getProjectIds() : user.getProjectIds())
                .noteIds(updateDto.getNoteIds() != null ? updateDto.getNoteIds() : user.getNoteIds())
                .issueIds(updateDto.getIssueIds() != null ? updateDto.getIssueIds() : user.getIssueIds())
                .commentIds(updateDto.getCommentIds() != null ? updateDto.getCommentIds() : user.getCommentIds())
                .build();
    }
}
