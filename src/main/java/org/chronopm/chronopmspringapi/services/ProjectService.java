package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.mappers.ProjectMapper;
import org.chronopm.chronopmspringapi.models.Project;
import org.chronopm.chronopmspringapi.repositories.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IEntityService<ProjectDto> {

    private final IProjectRepository projectRepository;
    private final IEntityManager entityManager;

    public ProjectService(IProjectRepository projectRepository, IEntityManager entityManager) {
        this.projectRepository = projectRepository;
        this.entityManager = entityManager;
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
        entityManager.handleProjectCreation(project);
        return ProjectMapper.mapToDto(project);
    }

    public ProjectDto update(ProjectDto dto, String id) {
        var existingProject = getProjectById(id);
        var updatedProject = ProjectMapper.mapForUpdate(dto, existingProject);
        updatedProject.setId(id);
        var project = projectRepository.save(updatedProject);
        return ProjectMapper.mapToDto(project);
    }

    public String delete(String id) {
        var project = getProjectById(id);
        entityManager.handleProjectDeletion(project);
        projectRepository.deleteById(id);
        return id;
    }

    private Project getProjectById(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }
}
