package org.example.ukrpost.repository;


import org.example.ukrpost.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, UUID> {
    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
