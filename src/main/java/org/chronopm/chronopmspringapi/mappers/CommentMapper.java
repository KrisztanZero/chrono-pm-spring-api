package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.CommentDto;
import org.chronopm.chronopmspringapi.models.Comment;

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
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
