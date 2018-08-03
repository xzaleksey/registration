package com.avalyakin.registration.mongo.visits;


import org.springframework.data.annotation.Id;

import lombok.Setter;

public class Visit {
    @Id
    public Long id;

    @Setter
    public String description;

    public Visit(Long id) {
        this.id = id;
    }
}
