package org.example;

import org.example.controllers.EventController;
import org.example.models.dtos.EventOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private final EventController eventController;

    public DataInitializer(EventController eventController) {
        this.eventController = eventController;
    }

    public void updateEvents() {
        List<EventOutputDTO> events = eventController.showAllEvents();
        for (EventOutputDTO eventOutputDTO : events) {
            if (eventOutputDTO.getDateTime().isBefore(LocalDateTime.now())) {
                eventController.completeEvent(eventOutputDTO.getId());
            }
        }
    }

    @Override
    public void run(String... args) throws Exception {
        updateEvents();
    }
}
