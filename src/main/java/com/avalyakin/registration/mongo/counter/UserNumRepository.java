package com.avalyakin.registration.mongo.counter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNumRepository extends MongoRepository<UserNum, String> {
    UserNum findTopByOrderByIdDesc();
}