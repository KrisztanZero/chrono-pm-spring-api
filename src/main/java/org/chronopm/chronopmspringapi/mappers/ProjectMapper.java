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

    public static Project mapForUpdate(ProjectDto updateProjectDto, Project project) {
        return Project.builder()
                .id(project.getId())
                .projectName(updateProjectDto.getProjectName() != null ? updateProjectDto.getProjectName() : project.getProjectName())
                .summary(updateProjectDto.getSummary() != null ? updateProjectDto.getSummary() : project.getSummary())
                .description(updateProjectDto.getDescription() != null ? updateProjectDto.getDescription() : project.getDescription())
                .authorId(updateProjectDto.getAuthorId() != null ? updateProjectDto.getAuthorId() : project.getAuthorId())
                .assigneeIds(updateProjectDto.getAssigneeIds() != null ? updateProjectDto.getAssigneeIds() : project.getAssigneeIds())
                .issueIds(updateProjectDto.getIssueIds() != null ? updateProjectDto.getIssueIds() : project.getIssueIds())
                .noteIds(updateProjectDto.getNoteIds() != null ? updateProjectDto.getNoteIds() : project.getNoteIds())
                .dueDate(updateProjectDto.getDueDate() != null ? updateProjectDto.getDueDate() : project.getDueDate())
                .createdAt(project.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .originalEstimate(project.getOriginalEstimate())
                .remainingEstimate(project.getRemainingEstimate())
                .build();
    }
}
