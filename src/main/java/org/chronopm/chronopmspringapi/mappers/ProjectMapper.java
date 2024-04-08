package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.models.Project;

import java.time.LocalDateTime;

public class ProjectMapper {
    public static ProjectDto mapToDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .summary(project.getSummary())
                .description(project.getDescription())
                .authorId(project.getAuthorId())
                .assigneeIds(project.getAssigneeIds())
                .issueIds(project.getIssueIds())
                .noteIds(project.getNoteIds())
                .dueDate(project.getDueDate())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .originalEstimate(project.getOriginalEstimate())
                .remainingEstimate(project.getRemainingEstimate())
                .build();
    }

    public static Project mapToModel(ProjectDto dto) {
        return Project.builder()
                .projectName(dto.getProjectName())
                .summary(dto.getSummary())
                .description(dto.getDescription())
                .authorId(dto.getAuthorId())
                .assigneeIds(dto.getAssigneeIds())
                .issueIds(dto.getIssueIds())
                .noteIds(dto.getNoteIds())
                .dueDate(dto.getDueDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .originalEstimate(dto.getOriginalEstimate())
                .remainingEstimate(dto.getRemainingEstimate())
                .build();
    }

    public static Project mapForUpdate(ProjectDto updateProjectDto) {
        return Project.builder()
                .projectName(updateProjectDto.getProjectName())
                .summary(updateProjectDto.getSummary())
                .description(updateProjectDto.getDescription())
                .assigneeIds(updateProjectDto.getAssigneeIds())
                .issueIds(updateProjectDto.getIssueIds())
                .noteIds(updateProjectDto.getNoteIds())
                .dueDate(updateProjectDto.getDueDate())
                .updatedAt(LocalDateTime.now())
                .remainingEstimate(updateProjectDto.getRemainingEstimate())
                .build();
    }
}
