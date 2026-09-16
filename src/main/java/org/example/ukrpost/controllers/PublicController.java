package org.example.ukrpost.controllers;


import org.example.ukrpost.entity.Parcel;
import org.example.ukrpost.entity.TrackingHistory;
import org.example.ukrpost.repository.TrackingHistoryRepository;
import org.example.ukrpost.services.ParcelService;
import org.springframework.web.bind.annotation.*;
import org.example.ukrpost.dto.*;

import java.util.List;

@RestController
@RequestMapping("api/parcel")
public class PublicController {
    private final ParcelService parcelService;
    private final TrackingHistoryRepository trackingHistoryRepository;
    public PublicController (ParcelService parcelService, TrackingHistoryRepository trackingHistoryRepository) {
        this.parcelService = parcelService;
        this.trackingHistoryRepository = trackingHistoryRepository;
    }

    @GetMapping("/{trackingNumber}")
    public Parcel getInfo(@PathVariable String trackingNumber) {return parcelService.getParcelInfo(trackingNumber);}

    @GetMapping("/{trackingNumber}/history")
    public List<TrackingHistory> getHistory(@PathVariable String trackingNumber) {return trackingHistoryRepository.findByParcelTrackingNumber(trackingNumber);}
}
