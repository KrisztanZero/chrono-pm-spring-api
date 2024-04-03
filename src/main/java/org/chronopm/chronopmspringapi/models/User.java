package org.chronopm.chronopmspringapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private List<String> projectId;
    private List<String> issueId;
    private List<String> commitId;
    private List<String> noteId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
