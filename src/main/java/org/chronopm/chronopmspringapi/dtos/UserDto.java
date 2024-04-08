package org.chronopm.chronopmspringapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
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
    private List<String> projectIds;
    private List<String> issueIds;
    private List<String> commentIds;
    private List<String> noteIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
