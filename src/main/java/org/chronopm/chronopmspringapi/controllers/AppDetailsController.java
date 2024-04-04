package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.AppDetailsDto;
import org.chronopm.chronopmspringapi.services.IEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appDetails")
public class AppDetailsController {
    private final IEntityService<AppDetailsDto> appDetailsService;

    public AppDetailsController(IEntityService<AppDetailsDto> appDetailsService) {
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
    public String delete(@PathVariable String id) {
        return appDetailsService.delete(id);
    }


}
