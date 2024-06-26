package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.IssueDto;
import org.chronopm.chronopmspringapi.models.Issue;

import java.time.LocalDateTime;

public class IssueMapper {
    public static IssueDto mapToDto(Issue issue) {
        return IssueDto.builder()
                .id(issue.getId())
                .authorId(issue.getAuthorId())
                .projectId(issue.getProjectId())
                .commentId(issue.getCommentId())
                .assigneeId(issue.getAssigneeId())
                .title(issue.getTitle())
                .summary(issue.getSummary())
                .description(issue.getDescription())
                .dueDate(issue.getDueDate())
                .originalEstimate(issue.getOriginalEstimate())
                .remainingEstimate(issue.getRemainingEstimate())
                .createdAt(issue.getCreatedAt())
                .updatedAt(issue.getUpdatedAt())
                .build();
    }

    public static Issue mapToModel(IssueDto dto) {
        return Issue.builder()
                .authorId(dto.getAuthorId())
                .projectId(dto.getProjectId())
                .commentId(dto.getCommentId())
                .assigneeId(dto.getAssigneeId())
                .title(dto.getTitle())
                .summary(dto.getSummary())
                .description(dto.getDescription())
                .dueDate(dto.getDueDate())
                .originalEstimate(dto.getOriginalEstimate())
                .remainingEstimate(dto.getRemainingEstimate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Issue mapForUpdate(IssueDto updateDto) {
        return Issue.builder()
                .commentId(updateDto.getCommentId())
                .assigneeId(updateDto.getAssigneeId())
                .title(updateDto.getTitle())
                .summary(updateDto.getSummary())
                .description(updateDto.getDescription())
                .dueDate(updateDto.getDueDate())
                .remainingEstimate(updateDto.getRemainingEstimate())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
