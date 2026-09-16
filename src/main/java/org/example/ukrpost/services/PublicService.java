package org.example.ukrpost.controllers;


import org.example.ukrpost.entity.Parcel;
import org.example.ukrpost.entity.TrackingHistory;
import org.example.ukrpost.repository.TrackingHistoryRepository;
import org.example.ukrpost.services.ParcelService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.example.ukrpost.dto.*;

import java.util.List;

@Service
public class PublicService {
    private final ParcelService parcelService;
    private final TrackingHistoryRepository trackingHistoryRepository;
    public PublicService (ParcelService parcelService, TrackingHistoryRepository trackingHistoryRepository) {
        this.parcelService = parcelService;
        this.trackingHistoryRepository = trackingHistoryRepository;
    }

    @GetMapping("/{trackingNumber}")
    public Parcel getInfo(@PathVariable String trackingNumber) {return parcelService.getParcelInfo(trackingNumber);}

    @GetMapping("/{trackingNumber}/history")
    public List<TrackingHistory> getHistory(@PathVariable String trackingNumber) {return trackingHistoryRepository.findByParcelTrackingNumber(trackingNumber);}
}
