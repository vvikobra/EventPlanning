package org.example.models.entities;

public enum Type {
    BIRTHDAY(0),
    WEDDING(1),
    CONFERENCE(2),
    CONCERT(3),
    OTHER(4);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
