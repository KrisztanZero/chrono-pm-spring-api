package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.CommitDto;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commits")
public class CommitController {
    private final EntityService<CommitDto> commitService;

    @Autowired
    public CommitController(EntityService<CommitDto> commitService) {
        this.commitService = commitService;
    }

    @GetMapping()
    public List<CommitDto> getAll() {
        return commitService.getAll();
    }

    @GetMapping("/{id}")
    public CommitDto getById(@PathVariable("id") String id) {
        return commitService.getById(id);
    }

    @PostMapping("/create")
    public CommitDto create(@RequestBody CommitDto commitDto) {
        return commitService.create(commitDto);
    }

    @PutMapping("/update/{id}")
    public CommitDto update(@RequestBody CommitDto commitDto, @PathVariable("id") String id) {
        return commitService.update(commitDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public DeleteResponse<CommitDto> delete(@PathVariable("id") String id) {
        return commitService.delete(id);
    }
}
