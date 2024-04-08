package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.NoteDto;
import org.chronopm.chronopmspringapi.models.Note;

import java.time.LocalDateTime;

public class NoteMapper {
    public static NoteDto mapToDto(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .projectId(note.getProjectId())
                .authorId(note.getAuthorId())
                .summary(note.getSummary())
                .description(note.getDescription())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }

    public static Note mapToModel(NoteDto noteDto) {
        return Note.builder()
                .projectId(noteDto.getProjectId())
                .authorId(noteDto.getAuthorId())
                .summary(noteDto.getSummary())
                .description(noteDto.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Note mapForUpdate(NoteDto updateDto, Note note) {
        return Note.builder()
                .id(note.getId())
                .projectId(updateDto.getProjectId() != null ? updateDto.getProjectId() : note.getProjectId())
                .authorId(updateDto.getAuthorId() != null ? updateDto.getAuthorId() : note.getAuthorId())
                .summary(updateDto.getSummary() != null ? updateDto.getSummary() : note.getSummary())
                .description(updateDto.getDescription() != null ? updateDto.getDescription() : note.getDescription())
                .createdAt(note.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
