package org.chronopm.chronopmspringapi.controllers;

import org.chronopm.chronopmspringapi.dtos.NoteDto;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    private final EntityService<NoteDto> noteService;

    @Autowired
    public NoteController(EntityService<NoteDto> noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public List<NoteDto> getAll() {
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public NoteDto getById(@PathVariable("id") String id) {
        return noteService.getById(id);
    }

    @PostMapping()
    public NoteDto create(@RequestBody NoteDto noteDto) {
        return noteService.create(noteDto);
    }

    @PutMapping("/{id}")
    public NoteDto update(@RequestBody NoteDto noteDto, @PathVariable("id") String id) {
        return noteService.update(noteDto, id);
    }

    @DeleteMapping("/{id}")
    public DeleteResponse<NoteDto> delete(@PathVariable("id") String id) {
        return noteService.delete(id);
    }
}
