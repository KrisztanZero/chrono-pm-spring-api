package org.chronopm.chronopmspringapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentDto {
    private String id;
    private String summary;
    private String description;
    private String authorId;
    private String issueId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
