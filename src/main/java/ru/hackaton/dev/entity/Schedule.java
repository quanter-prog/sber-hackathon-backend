package ru.hackaton.dev.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private UUID id;
    @ElementCollection
    private Map<LocalTime, String> stop;

    public Schedule() {
    }

    public Schedule(Map<LocalTime, String> stop) {
        this.stop = stop;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Map<LocalTime, String> getStop() {
        return stop;
    }

    public void setStop(Map<LocalTime, String> stop) {
        this.stop = stop;
    }
}
