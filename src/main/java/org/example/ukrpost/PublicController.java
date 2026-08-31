package org.example.ukrpost;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/parcel")
public class PublicController {
    private ParcelService parcelService;
    private TrackingHistoryRepository trackingHistoryRepository;
    public PublicController (ParcelService parcelService, TrackingHistoryRepository trackingHistoryRepository) {
        this.parcelService = parcelService;
        this.trackingHistoryRepository = trackingHistoryRepository;
    }

    @GetMapping("/{trackingNumber}")
    public Parcel getInfo(@PathVariable String trackingNumber) {return parcelService.getParcelInfo(trackingNumber);}

    @GetMapping("/{trackingNumber}/history")
    public List<Tracking_history> getHistory(@PathVariable String trackingNumber) {return trackingHistoryRepository.findByParcelTrackingNumber(trackingNumber);}
}
