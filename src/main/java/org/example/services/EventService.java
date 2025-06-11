package org.example.services;

import org.example.models.dtos.EventInputDTO;
import org.example.models.dtos.EventOutputDTO;

import java.util.List;

public interface EventService {
    EventOutputDTO create(EventInputDTO eventInputDTO);
    EventOutputDTO update(String id, EventInputDTO eventInputDTO);
    List<EventOutputDTO> findAll();
    EventOutputDTO findById(String id);
    EventOutputDTO cancel(String id);
    EventOutputDTO complete(String id);
    EventOutputDTO resume(String id);
}
