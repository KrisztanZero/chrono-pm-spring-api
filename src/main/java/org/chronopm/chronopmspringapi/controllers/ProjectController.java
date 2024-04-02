package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.ProjectDto;
import org.chronopm.chronopmspringapi.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final IProjectService projectService;
    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome here";
    }

    @GetMapping("/projects")
    public List<ProjectDto> getProjectList(){
        return projectService.getProjectList();
    }

    @PostMapping("/create-project")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto){
        return projectService.createProject(projectDto);
    }
}
