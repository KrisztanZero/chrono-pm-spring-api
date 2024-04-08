package org.chronopm.chronopmspringapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Builder.Default
    private List<String> projectIds = new ArrayList<>();
    @Builder.Default
    private List<String> issueIds = new ArrayList<>();
    @Builder.Default
    private List<String> commentIds = new ArrayList<>();
    @Builder.Default
    private List<String> noteIds = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
