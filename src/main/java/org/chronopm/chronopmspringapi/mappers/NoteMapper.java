package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.NoteDto;
import org.chronopm.chronopmspringapi.models.Note;

import java.time.LocalDateTime;

public class NoteMapper {
    public static NoteDto mapToDto(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .ProjectId(note.getProjectId())
                .authorId(note.getAuthorId())
                .summary(note.getSummary())
                .description(note.getDescription())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }

    public static Note mapToModel(NoteDto noteDto) {
        return Note.builder()
                .ProjectId(noteDto.getProjectId())
                .authorId(noteDto.getAuthorId())
                .summary(noteDto.getSummary())
                .description(noteDto.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Note mapForUpdate(NoteDto updateDto) {
        return Note.builder()
                .summary(updateDto.getSummary())
                .description(updateDto.getDescription())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
