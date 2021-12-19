package ru.hackaton.dev.service;

import ru.hackaton.dev.entity.Boat;
import ru.hackaton.dev.entity.dto.BoatDTO;

import java.util.List;
import java.util.Optional;

public interface IBoatService {

    Optional<List<Boat>> getAllBoats();

    Optional<Boat> getBoatById(String boatId);

    Boat addBoat(BoatDTO boatDTO);

    void deleteBoatById(String boatId);
}
