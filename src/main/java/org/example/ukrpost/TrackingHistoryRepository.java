package org.example.ukrpost;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrackingHistoryRepository extends JpaRepository<Tracking_history, String> {
    List<Tracking_history> findByParcelTrackingNumber(String trackingNumber);
}
