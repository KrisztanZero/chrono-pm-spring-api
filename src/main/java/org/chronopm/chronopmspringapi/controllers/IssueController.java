package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.IssueDto;
import org.chronopm.chronopmspringapi.services.IEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issue")
public class IssueController {
    private final IEntityService<IssueDto> issueService;

    public IssueController(IEntityService<IssueDto> issueService) {
        this.issueService = issueService;
    }

    @GetMapping()
    public List<IssueDto> getAll() {
        return issueService.getAll();
    }

    @GetMapping("/{id}")
    public IssueDto getById(@PathVariable("id") String id) {
        return issueService.getById(id);
    }

    @PostMapping()
    public IssueDto create(@RequestBody IssueDto issueDto) {
        return issueService.create(issueDto);
    }

    @PutMapping("/{id}")
    public IssueDto update(@RequestBody IssueDto issueDto, @PathVariable("id") String id) {
        return issueService.update(issueDto, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        return issueService.delete(id);
    }
}
