package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("appDetails")
@Data
@Builder
public class AppDetails {
    @Id
    private String id;
    private String welcomeMessage;
    private String introduction;
    private String version;
    private List<String> developers;
    private String copyRights;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
