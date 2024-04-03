package org.chronopm.chronopmspringapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("issues")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Issue {
    @Id
    private String id;
    private String title;
    private String summary;
    private String description;
    private String authorId;
    private List<String> assigneeId;
    private List<String> commentId;
    private String projectId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int originalEstimate;
    private int remainingEstimate;
}
