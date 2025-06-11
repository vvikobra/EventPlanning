package org.example.services;

import org.example.exceptions.EventNotFoundException;
import org.example.exceptions.InvalidEventDateException;
import org.example.models.dtos.EventInputDTO;
import org.example.models.dtos.EventOutputDTO;
import org.example.models.entities.Event;
import org.example.models.entities.Status;
import org.example.models.entities.Type;
import org.example.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventOutputDTO create(EventInputDTO eventInputDTO) {
        if (eventInputDTO.getDateTime().isBefore(LocalDateTime.now())) throw new InvalidEventDateException("Дата мероприятия должна быть позже настоящего времени!");
        Event event =
                new Event(eventInputDTO.getName(), eventInputDTO.getPlace(), eventInputDTO.getDateTime(), eventInputDTO.getOrganizer(), Type.valueOf(eventInputDTO.getEventType()));
        eventRepository.create(event);
        return this.mapEventToEventDto(event);
    }

    @Override
    public EventOutputDTO update(String id, EventInputDTO eventInputDTO) {
        Event event = eventRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EventNotFoundException(UUID.fromString(id)));
        event.setName(eventInputDTO.getName());
        event.setDateTime(eventInputDTO.getDateTime());
        event.setOrganizer(eventInputDTO.getOrganizer());
        event.setPlace(eventInputDTO.getPlace());
        eventRepository.update(event);
        return this.mapEventToEventDto(event);
    }

    @Override
    public List<EventOutputDTO> findAll() {
        List<EventOutputDTO> events = eventRepository.findAll().stream().map(this::mapEventToEventDto).toList();
        return events.stream().sorted(Comparator.comparing(EventOutputDTO::getDateTime)).toList();
    }

    @Override
    public EventOutputDTO findById(String id) {
        return this.mapEventToEventDto(eventRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EventNotFoundException(UUID.fromString(id))));
    }

    @Override
    public EventOutputDTO cancel(String id) {
        Event event = eventRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EventNotFoundException((UUID.fromString(id))));
        event.setStatus(Status.CANCELLED);
        eventRepository.update(event);
        return this.mapEventToEventDto(event);
    }

    @Override
    public EventOutputDTO complete(String id) {
        Event event = eventRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EventNotFoundException((UUID.fromString(id))));
        event.setStatus(Status.CONFIRMED);
        eventRepository.update(event);
        return this.mapEventToEventDto(event);
    }

    @Override
    public EventOutputDTO resume(String id) {
        Event event = eventRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EventNotFoundException((UUID.fromString(id))));
        if (event.getDateTime().isAfter(LocalDateTime.now())) event.setStatus(Status.PLANNING);
        else throw new IllegalStateException("Нельзя возобновить мероприятие, дата проведения которого раньше настоящего времени!");
        eventRepository.update(event);
        return this.mapEventToEventDto(event);
    }

    private EventOutputDTO mapEventToEventDto(Event event) {
        return new EventOutputDTO(event.getId().toString(), event.getName(), event.getPlace(), event.getDateTime(),
                event.getOrganizer(), event.getStatus().toString(), event.getType().toString());
    }
}
