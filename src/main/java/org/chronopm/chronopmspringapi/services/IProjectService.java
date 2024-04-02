package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;

import java.util.List;
public interface IProjectService {
    List<ProjectDto> getProjectList();
    ProjectDto createProject(ProjectDto projectDto);
}
