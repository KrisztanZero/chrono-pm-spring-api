package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.CommentDto;
import org.chronopm.chronopmspringapi.services.IEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final IEntityService<CommentDto> commentService;

    public CommentController(IEntityService<CommentDto> commentService) {
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

    @PutMapping("{id}")
    public CommentDto update(@RequestBody CommentDto updateComment, @PathVariable("id") String id) {
        return commentService.update(updateComment, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        return commentService.delete(id);
    }
}
