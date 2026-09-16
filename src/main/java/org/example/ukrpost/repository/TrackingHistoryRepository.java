package org.example.ukrpost.repository;

import org.example.ukrpost.entity.TrackingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, String> {
    List<TrackingHistory> findByParcelTrackingNumber(String trackingNumber);
}
