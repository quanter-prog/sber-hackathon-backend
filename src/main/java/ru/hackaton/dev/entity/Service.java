package ru.hackaton.dev.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID boatId;

    private String name;

    public Service() {
    }

    public Service(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
