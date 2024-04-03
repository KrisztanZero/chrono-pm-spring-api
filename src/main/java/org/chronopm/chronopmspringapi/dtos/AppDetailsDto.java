package org.chronopm.chronopmspringapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
