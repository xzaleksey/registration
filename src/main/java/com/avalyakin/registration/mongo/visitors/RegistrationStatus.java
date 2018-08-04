package com.avalyakin.registration.mongo.visitors;

public enum RegistrationStatus {
    NOT_REGISTERED(1),
    REGISTERED(2);

    private int value;

    RegistrationStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
