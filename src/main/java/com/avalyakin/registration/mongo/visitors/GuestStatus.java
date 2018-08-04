package com.avalyakin.registration.mongo.visitors;

public enum GuestStatus {
    COMMON(1),
    VIP(2);

    private int value;

    GuestStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
