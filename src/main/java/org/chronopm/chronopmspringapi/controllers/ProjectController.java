package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.services.IEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final IEntityService<ProjectDto> projectService;
    public ProjectController(IEntityService<ProjectDto> projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public List<ProjectDto> getProjectList(){
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable("id") String id){
        return projectService.getById(id);
    }

    @PostMapping()
    public ProjectDto createProject(@RequestBody ProjectDto projectDto){
        return projectService.create(projectDto);
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") String id){
        return projectService.update(projectDto, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable("id") String id){
        return projectService.delete(id);
    }
}
