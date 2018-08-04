package com.avalyakin.registration.mongo.visitors.rest;

import com.avalyakin.registration.mongo.visitors.Visitor;
import com.avalyakin.registration.mongo.visitors.VisitorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitorRepository visitorRepository;

    public ApiController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @RequestMapping(value = "/visitors", method = RequestMethod.GET)
    public Iterable<Visitor> getVisits() {
        return visitorRepository.findAll();
    }
}