package org.chronopm.chronopmspringapi.dtos.projectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProjectDto {
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
