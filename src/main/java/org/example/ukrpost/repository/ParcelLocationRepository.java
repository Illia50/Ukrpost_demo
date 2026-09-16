package org.example.ukrpost.repository;

import org.example.ukrpost.entity.ParcelLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParcelLocationRepository extends JpaRepository<ParcelLocation, UUID> {
}
