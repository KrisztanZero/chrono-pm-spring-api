package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("users")
@Data
@Builder
public class User {
    @Id
    private String id;
    private String authUserId;
    private String username;
    private String email;
    private String password;
    private String familyName;
    private String surname;
    private String introduction;
    private String phoneNumber;
    private List<String> projectIds;
    private List<String> issueIds;
    private List<String> commentIds;
    private List<String> noteIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
