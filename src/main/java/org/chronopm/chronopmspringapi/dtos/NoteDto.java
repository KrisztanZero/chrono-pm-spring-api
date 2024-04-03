package org.chronopm.chronopmspringapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDto {
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String ProjectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
