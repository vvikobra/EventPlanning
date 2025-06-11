package org.example.models.dtos;

import java.time.LocalDateTime;

public class EventOutputDTO {
    private String id;
    private String name;
    private String place;
    private LocalDateTime dateTime;
    private String organizer;
    private String status;
    private String type;

    public EventOutputDTO(String id, String name, String place, LocalDateTime dateTime, String organizer, String status, String type) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.dateTime = dateTime;
        this.organizer = organizer;
        this.status = status;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EventOutputDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", dateTime=" + dateTime +
                ", organizer='" + organizer + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
