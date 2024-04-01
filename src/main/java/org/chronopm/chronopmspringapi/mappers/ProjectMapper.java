package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.projectDto.ProjectDto;
import org.chronopm.chronopmspringapi.dtos.projectDto.UpdateProjectDto;
import org.chronopm.chronopmspringapi.models.Project;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

public class ProjectMapper {
    public static ProjectDto mapToDto(Project project){
        return ProjectDto.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .summary(project.getSummary())
                .description(project.getDescription())
                .authorId(project.getAuthorId())
                .assigneeId(project.getAssigneeId())
                .issueId(project.getIssueId())
                .noteId(project.getNoteId())
                .dueDate(project.getDueDate())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .originalEstimate(project.getOriginalEstimate())
                .remainingEstimate(project.getRemainingEstimate())
                .build();
    }

    public static Collection<ProjectDto> mapListToDto(Collection<Project> projectList){
        return projectList.stream()
                .map(ProjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static Project mapToModel (ProjectDto dto){
        return Project.builder()
                .projectName(dto.getProjectName())
                .summary(dto.getSummary())
                .description(dto.getDescription())
                .authorId(dto.getAuthorId())
                .assigneeId(dto.getAssigneeId())
                .issueId(dto.getIssueId())
                .noteId(dto.getNoteId())
                .dueDate(dto.getDueDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(dto.getUpdatedAt())
                .originalEstimate(dto.getOriginalEstimate())
                .remainingEstimate(dto.getRemainingEstimate())
                .build();
    }

    public static Project updateModelFromDto(UpdateProjectDto updateProjectDto){
        return Project.builder()
                .updatedAt(LocalDateTime.now())
                .projectName(updateProjectDto.getProjectName())
                .summary(updateProjectDto.getSummary())
                .description(updateProjectDto.getDescription())
                .assigneeId(updateProjectDto.getAssigneeId())
                .issueId(updateProjectDto.getIssueId())
                .noteId(updateProjectDto.getNoteId())
                .dueDate(updateProjectDto.getDueDate())
                .updatedAt(LocalDateTime.now())
                .originalEstimate(updateProjectDto.getOriginalEstimate())
                .remainingEstimate(updateProjectDto.getRemainingEstimate())
                .build();
    }
}
