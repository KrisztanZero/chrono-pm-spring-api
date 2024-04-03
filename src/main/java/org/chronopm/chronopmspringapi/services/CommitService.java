package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.CommitDto;
import org.chronopm.chronopmspringapi.mappers.CommitMapper;
import org.chronopm.chronopmspringapi.models.Commit;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.repositories.ICommitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommitService implements EntityService<CommitDto> {

    private final ICommitRepository commitRepository;

    public CommitService(ICommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }

    @Override
    public List<CommitDto> getAll() {
        return commitRepository.findAll()
                .stream()
                .map(CommitMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommitDto getById(String id) {
        return CommitMapper.mapToDto(getCommitById(id));
    }

    @Override
    public CommitDto create(CommitDto commitDto) {
        var commit = commitRepository.save(CommitMapper.mapToModel(commitDto));
        return CommitMapper.mapToDto(commit);
    }

    @Override
    public CommitDto update(CommitDto commitDto, String id) {
        return null;
    }

    @Override
    public DeleteResponse<CommitDto> delete(String id) {
        var commitDto = CommitMapper.mapToDto(getCommitById(id));
        commitRepository.deleteById(id);

        return DeleteResponse.<CommitDto>builder()
                .entity(commitDto)
                .message("Deleted Successful")
                .build();
    }

    private Commit getCommitById(String id) {
        return commitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Note not found"));

    }
}
