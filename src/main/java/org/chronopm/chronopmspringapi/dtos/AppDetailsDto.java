package org.chronopm.chronopmspringapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AppDetailsDto {
    private String id;
    private String welcomeMessage;
    private String introduction;
    private String version;
    private List<String> developers;
    private String copyRights;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
