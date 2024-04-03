package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.mappers.ProjectMapper;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.models.Project;
import org.chronopm.chronopmspringapi.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements EntityService<ProjectDto> {

    private final IProjectRepository projectRepository;

    @Autowired
    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getById(String id) {
        var project = getProjectById(id);

        return ProjectMapper.mapToDto(project);
    }

    public ProjectDto create(ProjectDto dto) {
        var project = projectRepository.save(ProjectMapper.mapToModel(dto));
        return ProjectMapper.mapToDto(project);
    }

    public ProjectDto update(ProjectDto dto, String id) {
        var updatedProject = ProjectMapper.mapForUpdate(dto);
        updatedProject.setId(id);
        projectRepository.save(updatedProject);
        return ProjectMapper.mapToDto(updatedProject);
    }

    public DeleteResponse<ProjectDto> delete(String id) {
        var project = getProjectById(id);

        projectRepository.deleteById(id);

        var projectDto = ProjectMapper.mapToDto(project);

        return DeleteResponse.<ProjectDto>builder()
                .entity(projectDto)
                .message("Deleted successful")
                .build();
    }

    private Project getProjectById(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }
}
