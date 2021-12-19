package ru.hackaton.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hackaton.dev.entity.Boat;

import java.util.UUID;

@Repository
public interface IBoatRepository extends JpaRepository<Boat, UUID> {

}
