package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.models.*;
import org.chronopm.chronopmspringapi.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class EntityManager implements IEntityManager {
    private final IUserRepository _userRepository;
    private final IProjectRepository _projectRepository;
    private final INoteRepository _noteRepository;
    private final IIssueRepository _issueRepository;
    private final ICommentRepository _commentRepository;

    public EntityManager(IUserRepository userRepository, IProjectRepository projectRepository, INoteRepository noteRepository, IIssueRepository issueRepository, ICommentRepository commentRepository) {
        _userRepository = userRepository;
        _projectRepository = projectRepository;
        _noteRepository = noteRepository;
        _issueRepository = issueRepository;
        _commentRepository = commentRepository;
    }

    @Override
    public void handleUserCreation(User user) {

    }

    @Override
    public void handleUserDeletion(User user) {

    }

    @Override
    public void handleProjectCreation(Project project) {
        var optionalUser = _userRepository.findById(project.getAuthorId());
        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("Project already associated with author: " + project.getId());
        }
        User author = optionalUser.get();
        if (author.getProjectIds().contains(project.getId())) {
            throw new IllegalArgumentException("Project already associated with author: " + project.getId());

        }
        author.getProjectIds().add(project.getId());

        for (var assigneeId : project.getAssigneeIds()) {
            var optionalAssignee = _userRepository.findById(assigneeId);
            if (!optionalAssignee.isPresent()) {
                throw new IllegalArgumentException("Project already associated with this assignee: " + project.getId());
            }
            User assignee = optionalAssignee.get();
            if (assignee.getProjectIds().contains(project.getId())) {
                throw new IllegalArgumentException("Project already associated with this assignee: " + project.getId());

            }
            assignee.getProjectIds().add(project.getId());
        }
    }

    @Override
    public void handleProjectDeletion(Project project) {

    }

    @Override
    public void handleNoteCreation(Note note) {

    }

    @Override
    public void handleNoteDeletion(Note note) {

    }

    @Override
    public void handleIssueCreation(Issue issue) {

    }

    @Override
    public void handleIssueDeletion(Issue issue) {

    }

    @Override
    public void handleCommentCreation(Comment comment) {

    }

    @Override
    public void handleCommentDeletion(Comment comment) {

    }
}
