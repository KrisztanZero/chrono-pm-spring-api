package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.NoteDto;
import org.chronopm.chronopmspringapi.mappers.NoteMapper;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.models.Note;
import org.chronopm.chronopmspringapi.repositories.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class NoteService implements EntityService<NoteDto> {
    private final INoteRepository noteRepository;

    @Autowired
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
        var updateNote = NoteMapper.mapForUpdate(dto);
        updateNote.setId(id);
        noteRepository.save(updateNote);
        return NoteMapper.mapToDto(updateNote);
    }

    @Override
    public DeleteResponse<NoteDto> delete(String id) {
        var noteDto = NoteMapper.mapToDto(getNoteById(id));
        noteRepository.deleteById(id);

        return DeleteResponse.<NoteDto>builder()
                .entity(noteDto)
                .message("Deleted Successful")
                .build();
    }

    private Note getNoteById(String id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Note not found"));

    }
}
