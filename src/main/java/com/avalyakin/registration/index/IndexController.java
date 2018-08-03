package com.avalyakin.registration.index;


import com.avalyakin.registration.mongo.counter.UserNumService;
import com.avalyakin.registration.mongo.visits.Visit;
import com.avalyakin.registration.mongo.visits.VisitsRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    private final VisitsRepository visitsRepository;
    private final UserNumService userNumService;

    public IndexController(VisitsRepository visitsRepository, UserNumService userNumService) {
        this.visitsRepository = visitsRepository;
        this.userNumService = userNumService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        Visit visit = new Visit(userNumService.getNext());
        visit.setDescription(String.format("Visited at %s", LocalDateTime.now()));
        visitsRepository.save(visit);
        return new ModelAndView("index", model);
    }


}
