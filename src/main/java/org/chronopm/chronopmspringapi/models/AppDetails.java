package org.chronopm.chronopmspringapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document("appDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
