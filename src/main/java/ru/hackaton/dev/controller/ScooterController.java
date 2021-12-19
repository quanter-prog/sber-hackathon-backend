package ru.hackaton.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hackaton.dev.entity.Scooter;
import ru.hackaton.dev.entity.dto.ScooterDTO;
import ru.hackaton.dev.service.IScooterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scooter")
public class ScooterController {

    private final IScooterService scooterService;

    @Autowired
    public ScooterController(IScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Scooter>> getAllScooters() {
        return scooterService.getAllScooters().map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/get")
    public ResponseEntity<Scooter> getScooterInfoById(@RequestParam String scooterId) {
        return scooterService.getScooterById(scooterId).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/add")
    public ResponseEntity<Scooter> addScooter(@RequestParam ScooterDTO scooterDTO) {
        return Optional.of(scooterService.addScooter(scooterDTO)).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build());
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam String scooterId) {
        scooterService.deleteScooterById(scooterId);
    }
}
