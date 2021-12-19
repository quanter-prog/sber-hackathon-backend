package ru.hackaton.dev.service;

import ru.hackaton.dev.entity.Scooter;
import ru.hackaton.dev.entity.dto.ScooterDTO;

import java.util.List;
import java.util.Optional;

public interface IScooterService {

    Optional<List<Scooter>> getAllScooters();

    Optional<Scooter> getScooterById(String scooterId);

    Scooter addScooter(ScooterDTO scooterDTO);

    void deleteScooterById(String scooterId);
}
