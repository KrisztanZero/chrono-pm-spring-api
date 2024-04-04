package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.UserDto;
import org.chronopm.chronopmspringapi.services.IEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IEntityService<UserDto> userService;

    public UserController(IEntityService<UserDto> userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @PostMapping()
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto userDto, @PathVariable("id") String id) {
        return userService.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        return userService.delete(id);
    }
}
