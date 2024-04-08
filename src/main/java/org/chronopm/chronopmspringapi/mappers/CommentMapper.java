package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.CommentDto;
import org.chronopm.chronopmspringapi.models.Comment;

import java.time.LocalDateTime;

public class CommentMapper {
    public static CommentDto mapToDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .authorId(comment.getAuthorId())
                .issueId(comment.getIssueId())
                .summary(comment.getSummary())
                .description(comment.getDescription())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public static Comment mapToModel(CommentDto dto) {
        return Comment.builder()
                .authorId(dto.getAuthorId())
                .issueId(dto.getIssueId())
                .summary(dto.getSummary())
                .description(dto.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Comment mapForUpdate(CommentDto updateDto, Comment comment) {
        return Comment.builder()
                .id(comment.getId())
                .authorId(updateDto.getAuthorId() != null ? updateDto.getAuthorId() : comment.getAuthorId())
                .issueId(updateDto.getIssueId() != null ? updateDto.getIssueId() : comment.getIssueId())
                .summary(updateDto.getSummary() != null ? updateDto.getSummary() : comment.getSummary())
                .description(updateDto.getDescription() != null ? updateDto.getDescription() : comment.getDescription())
                .createdAt(comment.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
