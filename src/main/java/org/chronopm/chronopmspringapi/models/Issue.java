package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("issues")
@Data
@Builder
public class Issue {
    @Id
    private String id;
    private String title;
    private String summary;
    private String description;
    private String authorId;
    private List<String> assigneeIds;
    private List<String> commentIds;
    private String projectId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int originalEstimate;
    private int remainingEstimate;
}
