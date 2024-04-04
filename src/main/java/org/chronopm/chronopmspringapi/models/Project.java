package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("projects")
@Data
@Builder
public class Project {
    @Id
    private String id;
    private String projectName;
    private String summary;
    private String description;
    private String authorId;
    private List<String> assigneeId;
    private List<String> issueId;
    private List<String> noteId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int originalEstimate;
    private int remainingEstimate;
}
