package org.example.exceptions;

import java.util.UUID;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(UUID id) {
        super("Мероприятие с id: " + id + " не существует!");
    }
}
