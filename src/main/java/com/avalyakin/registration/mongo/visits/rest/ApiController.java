package com.avalyakin.registration.mongo.visits.rest;

import com.avalyakin.registration.mongo.visits.Visit;
import com.avalyakin.registration.mongo.visits.VisitsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitsRepository visitsRepository;

    public ApiController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @RequestMapping(value = "/visits", method = RequestMethod.GET)
    public Iterable<Visit> getVisits() {
        return visitsRepository.findAll();
    }
}