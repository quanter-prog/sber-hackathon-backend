package ru.hackaton.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackaton.dev.entity.Scooter;
import ru.hackaton.dev.entity.dto.ScooterDTO;
import ru.hackaton.dev.repository.IScooterRepository;
import ru.hackaton.dev.service.IScooterService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScooterServiceImpl implements IScooterService {

    private final IScooterRepository scooterRepository;

    @Autowired
    public ScooterServiceImpl(IScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    @Override
    public Optional<List<Scooter>> getAllScooters() {
        return Optional.of(scooterRepository.findAll());
    }

    @Override
    public Optional<Scooter> getScooterById(String scooterId) {
        return scooterRepository.findById(UUID.fromString(scooterId));
    }

    @Override
    public Scooter addScooter(ScooterDTO scooterDTO) {
        Scooter scooter =
                new Scooter(
                        scooterDTO.getName(),
                        scooterDTO.getBattery(),
                        LocalDateTime.now(),
                        scooterDTO.getStatus()
                );
        return scooterRepository.save(scooter);
    }

    @Override
    public void deleteScooterById(String scooterId) {
        scooterRepository.deleteById(UUID.fromString(scooterId));
    }
}
