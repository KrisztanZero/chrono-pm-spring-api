package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;

import java.util.List;
public interface IProjectService {
    List<ProjectDto> getProjectList();
    ProjectDto getProjectById(String id);
    ProjectDto createProject(ProjectDto projectDto);
    ProjectDto updateProject(ProjectDto dto, String id);
    ProjectDto deleteProject(String id);
}
