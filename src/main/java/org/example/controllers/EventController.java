package org.example.controllers;

import org.example.models.dtos.EventInputDTO;
import org.example.models.dtos.EventOutputDTO;
import org.example.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {
    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping()
    public EventOutputDTO addEvent(@RequestBody EventInputDTO eventInputDTO) {
        return eventService.create(eventInputDTO);
    }

    @GetMapping()
    public List<EventOutputDTO> showAllEvents() {
        return eventService.findAll();
    }

    @PostMapping("/cancel/{eventId}")
    public EventOutputDTO cancelEvent(@PathVariable String eventId) {
        return eventService.cancel(eventId);
    }

    @PostMapping("/complete/{eventId}")
    public EventOutputDTO completeEvent(@PathVariable String eventId) {
        return eventService.complete(eventId);
    }

    @PostMapping("/resume/{eventId}")
    public EventOutputDTO resumeEvent(@PathVariable String eventId) {
        return eventService.resume(eventId);
    }
}
