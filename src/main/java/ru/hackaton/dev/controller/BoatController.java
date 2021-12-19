package ru.hackaton.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hackaton.dev.entity.Boat;
import ru.hackaton.dev.entity.dto.BoatDTO;
import ru.hackaton.dev.service.IBoatService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boat")
public class BoatController {

    private final IBoatService boatService;

    @Autowired
    public BoatController(IBoatService boatService) {
        this.boatService = boatService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Boat>> getAllBoatsInfo() {
        return boatService.getAllBoats().map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/get")
    public ResponseEntity<Boat> getBoatInfoById(@RequestParam String boatId) {
        return boatService.getBoatById(boatId).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/add")
    public ResponseEntity<Boat> addBoat(@RequestBody BoatDTO boatDTO) {
        return Optional.of(boatService.addBoat(boatDTO)).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build());
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam String boatId) {
        boatService.deleteBoatById(boatId);
    }
}
