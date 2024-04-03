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
public class UserDto {
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
    private List<String> commentId;
    private List<String> noteId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
