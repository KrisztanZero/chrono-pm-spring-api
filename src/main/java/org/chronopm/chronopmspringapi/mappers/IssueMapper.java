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
                .commentIds(issue.getCommentIds())
                .assigneeIds(issue.getAssigneeIds())
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
                .commentIds(dto.getCommentIds())
                .assigneeIds(dto.getAssigneeIds())
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

    public static Issue mapForUpdate(IssueDto updateDto, Issue issue) {
        issue.setAuthorId(updateDto.getAuthorId() != null ? updateDto.getAuthorId() : issue.getAuthorId());
        issue.setProjectId(updateDto.getProjectId() != null ? updateDto.getProjectId() : issue.getProjectId());
        issue.setCommentIds(updateDto.getCommentIds() != null ? updateDto.getCommentIds() : issue.getCommentIds());
        issue.setAssigneeIds(updateDto.getAssigneeIds() != null ? updateDto.getAssigneeIds() : issue.getAssigneeIds());
        issue.setTitle(updateDto.getTitle() != null ? updateDto.getTitle() : issue.getTitle());
        issue.setSummary(updateDto.getSummary() != null ? updateDto.getSummary() : issue.getSummary());
        issue.setDescription(updateDto.getDescription() != null ? updateDto.getDescription() : issue.getDescription());
        issue.setDueDate(updateDto.getDueDate() != null ? updateDto.getDueDate() : issue.getDueDate());
        issue.setOriginalEstimate(updateDto.getOriginalEstimate() != 0 ? updateDto.getOriginalEstimate() : issue.getOriginalEstimate());
        issue.setRemainingEstimate(updateDto.getRemainingEstimate() != 0 ? updateDto.getRemainingEstimate() : issue.getRemainingEstimate());
        issue.setUpdatedAt(LocalDateTime.now());
        return issue;
    }
}
