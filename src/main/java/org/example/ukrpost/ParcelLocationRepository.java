package org.example.ukrpost;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParcelLocationRepository extends JpaRepository<Parcel_location, UUID> {
}
