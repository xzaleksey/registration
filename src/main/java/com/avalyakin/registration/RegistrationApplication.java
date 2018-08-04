package com.avalyakin.registration;

import com.avalyakin.registration.mongo.config.SpringMongoConfig;
import com.avalyakin.registration.mongo.visitors.Visitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class RegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
        Visitor visitor = new Visitor(100L);
//        mongoOperations.save(visitor, "visits1");
        Query query = new Query();
        mongoOperations.dropCollection("visits1");
        mongoOperations.dropCollection("visits");
        query.addCriteria(Criteria.where("description").is("desc"));
        Visitor foundVisitor = mongoOperations.findOne(query, Visitor.class, "visits1");
        System.out.println(foundVisitor);
    }
}
