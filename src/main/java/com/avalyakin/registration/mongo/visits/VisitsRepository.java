package com.avalyakin.registration.mongo.visits;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsRepository extends MongoRepository<Visit, Long> {
}
