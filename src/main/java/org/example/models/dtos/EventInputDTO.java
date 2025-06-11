package org.example.models.dtos;

import java.time.LocalDateTime;

public class EventInputDTO {
    private String name;
    private String place;
    private LocalDateTime dateTime;
    private String organizer;
    private String eventType;

    public EventInputDTO(String name, String place, LocalDateTime dateTime, String organizer, String eventType) {
        this.name = name;
        this.place = place;
        this.dateTime = dateTime;
        this.organizer = organizer;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "EventInputDTO{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", dateTime=" + dateTime +
                ", organizer='" + organizer + '\'' +
                ", type='" + eventType + '\'' +
                '}';
    }
}
