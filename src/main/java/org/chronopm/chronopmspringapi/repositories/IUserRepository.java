package org.chronopm.chronopmspringapi.repositories;

import org.chronopm.chronopmspringapi.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IUserRepository extends MongoRepository<User, String> {
}
