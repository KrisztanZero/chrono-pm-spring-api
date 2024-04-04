package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("comments")
@Data
@Builder
public class Comment {
    @Id
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String issueId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
