package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
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

    public ProjectDto getProjectById(String id) {
        var project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        return ProjectMapper.mapToDto(project);
    }

    public ProjectDto createProject(ProjectDto dto) {
        var project = projectRepository.save(ProjectMapper.mapToModel(dto));
        return ProjectMapper.mapToDto(project);
    }

    public ProjectDto updateProject(ProjectDto dto, String id) {
        var existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        var updatedProject = ProjectMapper.mapForUpdate(dto);
        updatedProject.setId(existingProject.getId());

        projectRepository.save(updatedProject);

        return ProjectMapper.mapToDto(updatedProject);
    }

    public ProjectDto deleteProject(String id) {
        var project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        projectRepository.deleteById(id);

        return ProjectMapper.mapToDto(project);
    }
}
