package com.avalyakin.registration.mongo.visitors.factory;

import com.avalyakin.registration.mongo.visitors.Visitor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitorsRepositoryFactory {
    MongoRepository<Visitor, ObjectId> createRepository(String collectionName);
}
