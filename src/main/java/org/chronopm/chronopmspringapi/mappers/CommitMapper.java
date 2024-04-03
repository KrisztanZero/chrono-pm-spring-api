package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.CommitDto;
import org.chronopm.chronopmspringapi.models.Commit;

public class CommitMapper {
    public static CommitDto mapToDto(Commit commit) {
        return CommitDto.builder()
                .id(commit.getId())
                .authorId(commit.getAuthorId())
                .issueId(commit.getIssueId())
                .summary(commit.getSummary())
                .description(commit.getDescription())
                .createdAt(commit.getCreatedAt())
                .build();
    }

    public static Commit mapToModel(CommitDto dto) {
        return Commit.builder()
                .authorId(dto.getAuthorId())
                .issueId(dto.getIssueId())
                .summary(dto.getSummary())
                .description(dto.getDescription())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
