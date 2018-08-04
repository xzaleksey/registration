package com.avalyakin.registration.mongo.visitors;


import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Visitor {

    @Id
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String surName;
    @Getter
    @Setter
    private String patronymic;
    @Getter
    @Setter
    private long companyId;
    @Getter
    @Setter
    private LocalDateTime registrationDate;
    @Getter
    @Setter
    private int status;
    @Getter
    @Setter
    private int registrationStatus;


    public Visitor(Long id) {
        this.id = id;
    }

}
