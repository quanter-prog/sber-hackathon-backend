package ru.hackaton.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.hackaton.dev.entity.Boat;
import ru.hackaton.dev.entity.dto.BoatDTO;
import ru.hackaton.dev.repository.IBoatRepository;
import ru.hackaton.dev.service.IBoatService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class BoatServiceImpl implements IBoatService {

    private final IBoatRepository boatRepository;
    private Map<String, String> positions;

    @Autowired
    public BoatServiceImpl(IBoatRepository repository) {
        this.boatRepository = repository;
        positions = new HashMap<>();
        positions.put("55.707546", "37.647602");
        positions.put("55.707658", "37.647931");
        positions.put("55.708054", "37.648479");
        positions.put("55.708489", "37.648851");
        positions.put("55.708853", "37.649256");
        positions.put("55.709184", "37.649667");
        positions.put("55.709633", "37.649987");
        positions.put("55.710109", "37.650167");
        positions.put("55.710479", "37.650334");
        positions.put("55.711342", "37.650203");
        positions.put("55.711781", "37.650067");
        positions.put("55.712162", "37.649991");
        positions.put("55.712503", "37.649757");
        positions.put("55.713303", "37.649256");
        positions.put("55.714220", "37.648934");
        positions.put("55.715478", "37.648487");
    }

    @Override
    public Optional<List<Boat>> getAllBoats() {
        return Optional.of(boatRepository.findAll());
    }

    @Override
    public Optional<Boat> getBoatById(String boatId) {
        return boatRepository.findById(UUID.fromString(boatId));
    }

    @Override
    public Boat addBoat(BoatDTO boatDTO) {
        Boat boat =
                new Boat(
                        boatDTO.getName(),
                        boatDTO.getSeatsCount(),
                        boatDTO.getFreeSeatsCount(),
                        boatDTO.getLongitude(),
                        boatDTO.getLatitude(),
                        boatDTO.getRouteName(),
                        boatDTO.getDestinationTime(),
                        boatDTO.getNextStopName(),
                        boatDTO.getServices()
                );

        return boatRepository.save(boat);
    }

    @Override
    public void deleteBoatById(String boatId) {
        boatRepository.deleteById(UUID.fromString(boatId));
    }

    @Scheduled(fixedDelay = 1000*4)
    private void updateCoordinates() {
        Optional<Boat> optionalBoat = boatRepository.findById(UUID.fromString("296117d7-963c-452f-8a76-2b3959bab83e"));
        if (optionalBoat.isPresent()) {
            List<String> keys = new ArrayList<>(positions.keySet());
            int keyNumber = 0;
            for (int i = 0; i < keys.size(); i++) {
                if (keys.get(i).equals(optionalBoat.get().getLatitude())) {
                    keyNumber = i;
                    break;
                }
            }
            if (keyNumber + 1 == keys.size()) {
                keyNumber = 0;
            }
            optionalBoat.get().setLatitude(keys.get(keyNumber + 1));
            optionalBoat.get().setLongitude(positions.getOrDefault(keys.get(keyNumber + 1), "228.1488"));
            boatRepository.save(optionalBoat.get());
        }
    }
}
