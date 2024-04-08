package org.chronopm.chronopmspringapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProjectDto {
    private String id;
    private String projectName;
    private String summary;
    private String description;
    private String authorId;
    private List<String> assigneeIds;
    private List<String> issueIds;
    private List<String> noteIds;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int originalEstimate;
    private int remainingEstimate;
}
