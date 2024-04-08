package org.chronopm.chronopmspringapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NoteDto {
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String projectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
