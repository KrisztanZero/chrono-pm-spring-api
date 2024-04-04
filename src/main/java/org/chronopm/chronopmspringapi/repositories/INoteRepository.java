package org.chronopm.chronopmspringapi.repositories;

import org.chronopm.chronopmspringapi.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends MongoRepository<Note, String> {
}
