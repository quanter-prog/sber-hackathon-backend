package ru.hackaton.dev.entity.dto;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.UUID;

public class BoatDTO {
    private UUID id;
    private String name;
    private int seatsCount;
    private int freeSeatsCount;
    private String longitude;
    private String latitude;
    private String routeName;
    private String destinationTime;
    private String nextStopName;

    @ElementCollection
    private List<String> services;

    public BoatDTO() {
    }

    public BoatDTO(UUID id, String name, int seatsCount, int freeSeatsCount, String longitude, String latitude, String routeName, String destinationTime, String nextStopName, List<String> services) {
        this.id = id;
        this.name = name;
        this.seatsCount = seatsCount;
        this.freeSeatsCount = freeSeatsCount;
        this.longitude = longitude;
        this.latitude = latitude;
        this.routeName = routeName;
        this.destinationTime = destinationTime;
        this.nextStopName = nextStopName;
        this.services = services;
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

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public int getFreeSeatsCount() {
        return freeSeatsCount;
    }

    public void setFreeSeatsCount(int freeSeatsCount) {
        this.freeSeatsCount = freeSeatsCount;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getNextStopName() {
        return nextStopName;
    }

    public void setNextStopName(String nextStopName) {
        this.nextStopName = nextStopName;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
