package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Builder.Default
    private List<String> assigneeIds = new ArrayList<>();
    @Builder.Default
    private List<String> commentIds = new ArrayList<>();
    private String projectId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int originalEstimate;
    private int remainingEstimate;
}
