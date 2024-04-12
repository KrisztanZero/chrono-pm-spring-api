package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.models.*;

public interface IEntityManager {
    void handleUserCreation(User user);
    void handleUserDeletion(User user);
    void handleProjectCreation(Project project);
    void handleProjectDeletion(Project project);
    void handleNoteCreation(Note note);
    void handleNoteDeletion(Note note);
    void handleIssueCreation(Issue issue);
    void handleIssueDeletion(Issue issue);
    void handleCommentCreation(Comment comment);
    void handleCommentDeletion(Comment comment);
}
