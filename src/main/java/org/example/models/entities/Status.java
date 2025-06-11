package org.example.models.entities;

public enum Status {
    PLANNING(0), CONFIRMED(1), CANCELLED(2);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
