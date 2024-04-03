package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.UserDto;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final EntityService<UserDto> userService;

    @Autowired
    public UserController(EntityService<UserDto> userService) {
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
    public DeleteResponse<UserDto> delete(@PathVariable("id") String id) {
        return userService.delete(id);
    }
}
