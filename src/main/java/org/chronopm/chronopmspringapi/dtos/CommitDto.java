package org.chronopm.chronopmspringapi.dtos;

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
public class CommitDto {
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String issueId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
