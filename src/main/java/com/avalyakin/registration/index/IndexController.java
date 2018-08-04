package com.avalyakin.registration.index;


import com.avalyakin.registration.mongo.counter.UserNumService;
import com.avalyakin.registration.mongo.visitors.Visitor;
import com.avalyakin.registration.mongo.visitors.factory.VisitorsRepositoryFactory;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    private final VisitorsRepositoryFactory visitorsRepositoryFactory;
    private final UserNumService userNumService;

    public IndexController(VisitorsRepositoryFactory visitorRepository, UserNumService userNumService) {
        this.visitorsRepositoryFactory = visitorRepository;
        this.userNumService = userNumService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        Visitor visitor = new Visitor(userNumService.getNext());
        MongoRepository<Visitor, ObjectId> repository = visitorsRepositoryFactory.createRepository("visitors1");
        repository.save(visitor);
        return new ModelAndView("index", model);
    }


}
