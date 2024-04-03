package org.chronopm.chronopmspringapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("commits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commit {
    @Id
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String issueId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
