package com.avalyakin.registration.mongo.counter;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public class UserNum {

    @Id
    private ObjectId id;

    @Getter
    @Setter
    private long seq;

    public UserNum(long seq) {
        this.seq = seq;
    }

}