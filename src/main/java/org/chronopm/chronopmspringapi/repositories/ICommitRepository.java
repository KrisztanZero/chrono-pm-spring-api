package org.chronopm.chronopmspringapi.repositories;

import org.chronopm.chronopmspringapi.models.Commit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommitRepository extends MongoRepository<Commit, String> {
}
