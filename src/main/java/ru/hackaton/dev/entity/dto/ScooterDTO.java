package ru.hackaton.dev.entity.dto;

import ru.hackaton.dev.entity.enums.ScooterStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class ScooterDTO {
    private UUID id;
    private String name;
    private int battery;
    private LocalDateTime usageTime;
    private ScooterStatus status;

    public ScooterDTO() {
    }

    public ScooterDTO(UUID id, String name, int battery, LocalDateTime usageTime, ScooterStatus status) {
        this.id = id;
        this.name = name;
        this.battery = battery;
        this.usageTime = usageTime;
        this.status = status;
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

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public LocalDateTime getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(LocalDateTime usageTime) {
        this.usageTime = usageTime;
    }

    public ScooterStatus getStatus() {
        return status;
    }

    public void setStatus(ScooterStatus status) {
        this.status = status;
    }
}
