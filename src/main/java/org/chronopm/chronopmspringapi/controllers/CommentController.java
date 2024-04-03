package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.CommentDto;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final EntityService<CommentDto> commentService;

    @Autowired
    public CommentController(EntityService<CommentDto> commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public List<CommentDto> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public CommentDto getById(@PathVariable("id") String id) {
        return commentService.getById(id);
    }

    @PostMapping()
    public CommentDto create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PutMapping("/{id}")
    public CommentDto update(@RequestBody CommentDto commentDto, @PathVariable("id") String id) {
        return commentService.update(commentDto, id);
    }

    @DeleteMapping("/{id}")
    public DeleteResponse<CommentDto> delete(@PathVariable("id") String id) {
        return commentService.delete(id);
    }
}
