package org.chronopm.chronopmspringapi.repositories;

import org.chronopm.chronopmspringapi.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends MongoRepository<Comment, String> {
}
