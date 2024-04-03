package org.chronopm.chronopmspringapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    @Id
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String ProjectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
