package org.chronopm.chronopmspringapi.repositories;

import org.chronopm.chronopmspringapi.models.AppDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppDetailsRepository extends MongoRepository<AppDetails, String> {
}
