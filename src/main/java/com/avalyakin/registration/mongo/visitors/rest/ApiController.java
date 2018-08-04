package com.avalyakin.registration.mongo.visitors.rest;

import com.avalyakin.registration.mongo.visitors.Visitor;
import com.avalyakin.registration.mongo.visitors.factory.VisitorsRepositoryFactory;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitorsRepositoryFactory visitorRepository;

    public ApiController(VisitorsRepositoryFactory visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @RequestMapping(value = "/visitors{id}", method = RequestMethod.GET)
    public Iterable<Visitor> getVisits(@PathVariable("id") String id) {
        System.out.println("request visitors " + id);
        MongoRepository<Visitor, ObjectId> repository = visitorRepository.createRepository("visitors" + id);
        return repository.findAll();
    }
}