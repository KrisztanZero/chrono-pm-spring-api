package org.chronopm.chronopmspringapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class IssueDto {
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
