package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final IProjectService projectService;
    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public List<ProjectDto> getProjectList(){
        return projectService.getProjectList();
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable("id") String id){
        return projectService.getProjectById(id);
    }

    @PostMapping("/create")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto){
        return projectService.createProject(projectDto);
    }

    @PutMapping("/update/{id}")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") String id){
        return projectService.updateProject(projectDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ProjectDto deleteProject(@PathVariable("id") String id){
        return projectService.deleteProject(id);
    }
}
