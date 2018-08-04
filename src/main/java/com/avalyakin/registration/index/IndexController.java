package com.avalyakin.registration.index;


import com.avalyakin.registration.mongo.counter.UserNumService;
import com.avalyakin.registration.mongo.visitors.Visitor;
import com.avalyakin.registration.mongo.visitors.VisitorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    private final VisitorRepository visitorRepository;
    private final UserNumService userNumService;

    public IndexController(VisitorRepository visitorRepository, UserNumService userNumService) {
        this.visitorRepository = visitorRepository;
        this.userNumService = userNumService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        Visitor visitor = new Visitor(userNumService.getNext());
        visitorRepository.save(visitor);
        return new ModelAndView("index", model);
    }


}
