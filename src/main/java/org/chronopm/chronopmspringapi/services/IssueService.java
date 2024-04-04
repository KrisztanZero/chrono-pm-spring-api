package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.IssueDto;
import org.chronopm.chronopmspringapi.mappers.IssueMapper;
import org.chronopm.chronopmspringapi.models.Issue;
import org.chronopm.chronopmspringapi.repositories.IIssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService implements IEntityService<IssueDto> {

    private final IIssueRepository issueRepository;

    public IssueService(IIssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<IssueDto> getAll() {
        return issueRepository.findAll()
                .stream()
                .map(IssueMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public IssueDto getById(String id) {
        return IssueMapper.mapToDto(getIssueById(id));
    }

    @Override
    public IssueDto create(IssueDto issueDto) {
        var issue = issueRepository.save(IssueMapper.mapToModel(issueDto));
        return IssueMapper.mapToDto(issue);
    }

    @Override
    public IssueDto update(IssueDto issueDto, String id) {
        var updatedIssue = IssueMapper.mapForUpdate(issueDto);
        updatedIssue.setId(id);
        var issue = issueRepository.save(updatedIssue);
        return IssueMapper.mapToDto(issue);
    }

    @Override
    public String delete(String id) {
        issueRepository.deleteById(id);
        return id;
    }

    private Issue getIssueById(String id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Issue not found"));
    }
}
