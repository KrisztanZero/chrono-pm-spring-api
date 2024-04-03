package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.AppDetailsDto;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appDetails")
public class AppDetailsController {
    private final EntityService<AppDetailsDto> appDetailsService;

    @Autowired
    public AppDetailsController(EntityService<AppDetailsDto> appDetailsService) {
        this.appDetailsService = appDetailsService;
    }

    @GetMapping
    public List<AppDetailsDto> getAll() {
        return appDetailsService.getAll();
    }

    @GetMapping("/{id}")
    public AppDetailsDto getAppDetails(@PathVariable String id) {
        return appDetailsService.getById(id);
    }

    @PostMapping
    public AppDetailsDto create(@RequestBody AppDetailsDto dto) {
        return appDetailsService.create(dto);
    }

    @PutMapping("/{id}")
    public AppDetailsDto update(@RequestBody AppDetailsDto updateDto, @PathVariable String id) {
        return appDetailsService.update(updateDto, id);
    }

    @DeleteMapping("/{id}")
    public DeleteResponse<AppDetailsDto> delete(@PathVariable String id) {
        return appDetailsService.delete(id);
    }


}
