package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final EntityService<ProjectDto> projectService;
    @Autowired
    public ProjectController(EntityService<ProjectDto> projectService) {
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

    @PostMapping("/create")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto){
        return projectService.create(projectDto);
    }

    @PutMapping("/update/{id}")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") String id){
        return projectService.update(projectDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public DeleteResponse<ProjectDto> deleteProject(@PathVariable("id") String id){
        return projectService.delete(id);
    }
}
