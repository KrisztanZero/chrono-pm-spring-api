package org.chronopm.chronopmspringapi.repositories;

import org.chronopm.chronopmspringapi.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends MongoRepository<Project,String> {

}
