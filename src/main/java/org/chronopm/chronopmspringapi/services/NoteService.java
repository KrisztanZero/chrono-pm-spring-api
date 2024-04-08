package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.NoteDto;
import org.chronopm.chronopmspringapi.mappers.NoteMapper;
import org.chronopm.chronopmspringapi.models.Note;
import org.chronopm.chronopmspringapi.repositories.INoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService implements IEntityService<NoteDto> {
    private final INoteRepository noteRepository;

    public NoteService(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<NoteDto> getAll() {
        return noteRepository.findAll()
                .stream()
                .map(NoteMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public NoteDto getById(String id) {
        return NoteMapper.mapToDto(getNoteById(id));
    }

    @Override
    public NoteDto create(NoteDto dto) {
        var note = noteRepository.save(NoteMapper.mapToModel(dto));
        return NoteMapper.mapToDto(note);
    }

    @Override
    public NoteDto update(NoteDto dto, String id) {
        var existingNote = getNoteById(id);
        var updateNote = NoteMapper.mapForUpdate(dto, existingNote);
        updateNote.setId(id);
        var note = noteRepository.save(updateNote);
        return NoteMapper.mapToDto(note);
    }

    @Override
    public String delete(String id) {
        noteRepository.deleteById(id);

        return id;
    }

    private Note getNoteById(String id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));

    }
}
