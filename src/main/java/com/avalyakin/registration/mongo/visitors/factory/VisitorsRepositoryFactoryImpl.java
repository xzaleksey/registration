package com.avalyakin.registration.mongo.visitors.factory;

import com.avalyakin.registration.mongo.visitors.Visitor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.stereotype.Component;

@Component
public class VisitorsRepositoryFactoryImpl implements VisitorsRepositoryFactory {

    private MongoOperations mongoOperations;

    public VisitorsRepositoryFactoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public MongoRepository<Visitor, ObjectId> createRepository(String collectionName) {
        MappingMongoEntityInformation<Visitor, ObjectId> visitorObjectMappingMongoEntityInformation = new MappingMongoEntityInformation<>(
                new BasicMongoPersistentEntity<>(ClassTypeInformation.from(Visitor.class)),
                collectionName);
        return new SimpleMongoRepository<>(visitorObjectMappingMongoEntityInformation, mongoOperations);
    }
}
