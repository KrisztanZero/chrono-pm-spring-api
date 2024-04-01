package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.projectDto.ProjectDto;
import org.chronopm.chronopmspringapi.mappers.ProjectMapper;
import org.chronopm.chronopmspringapi.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    private final IProjectRepository projectRepository;

    @Autowired
    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getProjectList() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public ProjectDto createProject(ProjectDto dto) {
        var project = projectRepository.save(ProjectMapper.mapToModel(dto));
        return ProjectMapper.mapToDto(project);
    }
}
