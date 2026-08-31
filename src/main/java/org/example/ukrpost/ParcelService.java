package org.example.ukrpost;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final TruckRepository truckRepository;
    private final OperatorAccountRepository operatorAccountRepository;
    private final TrackingHistoryRepository trackingHistoryRepository;
    public ParcelService(ParcelRepository parcelRepository, TruckRepository truckRepository, OperatorAccountRepository operatorAccountRepository, TrackingHistoryRepository trackingHistoryRepository){
        this.parcelRepository = parcelRepository;
        this.truckRepository = truckRepository;
        this.operatorAccountRepository = operatorAccountRepository;
        this.trackingHistoryRepository = trackingHistoryRepository;
    }

    public Parcel getParcelInfo (String trackingNumber){
        Optional<Parcel> res = parcelRepository.findByTrackingNumber(trackingNumber);
        if (res.isPresent()){
            Parcel resParcel = res.get();
            return resParcel;
        }
        else {
            throw new RuntimeException("Parcel with number " + trackingNumber + " not found.");
        }
    }

    public void createParcel(String description, LocalDateTime time_now){
        Parcel parcel = new Parcel();
        String trackN;
        final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int rindex = ThreadLocalRandom.current().nextInt(26);
        char track1 = symbols.charAt(rindex);
        rindex = ThreadLocalRandom.current().nextInt(26);
        char track2 = symbols.charAt(rindex);
        int track3 = ThreadLocalRandom.current().nextInt(100000000, 1000000000);
        parcel.setId(UUID.randomUUID());
        parcel.setTrackingNumber("" + track1 + track2 + track3 + "UA");
        parcel.setDescription(description);
        parcel.setStatus("CREATED");

        Tracking_history tracking_history = new Tracking_history();
        tracking_history.setId(UUID.randomUUID());
        tracking_history.setParcel(parcel);
        tracking_history.setStatus("CREATED");
        tracking_history.setUpdatedAt(time_now);
        tracking_history.setLocation(null);
        tracking_history.setTruck(null);
        tracking_history.setAccount(null);

        parcelRepository.save(parcel);
        trackingHistoryRepository.save(tracking_history);
    }

    public void loadTruck (Parcel parcel, LocalDateTime time_now, Truck truck, OperatorAccount operatorAccount){

        parcel.setCurrentTruck(truck);
        parcel.setStatus("IN TRANSIT");
        parcel.setCurrentLocation(null);
        Tracking_history tracking_history = new Tracking_history();
        tracking_history.setParcel(parcel);
        tracking_history.setStatus("IN TRANSIT");
        tracking_history.setUpdatedAt(time_now);
        tracking_history.setLocation(null);
        tracking_history.setTruck(truck);
        tracking_history.setAccount(operatorAccount);
        parcelRepository.save(parcel);
        truckRepository.save(truck);
        trackingHistoryRepository.save(tracking_history);
    }

    public void arrivedToPostOffice (Parcel parcel, Parcel_location parcelLocation, OperatorAccount operatorAccount, LocalDateTime time_now){
        parcel.setCurrentLocation(parcelLocation);
        parcel.setStatus("ARRIVED");
        parcel.setCurrentTruck(null);
        Tracking_history tracking_history = new Tracking_history();
        tracking_history.setParcel(parcel);
        tracking_history.setStatus("ARRIVED");
        tracking_history.setUpdatedAt(time_now);
        tracking_history.setLocation(parcelLocation);
        tracking_history.setTruck(null);
        tracking_history.setAccount(operatorAccount);
        parcelRepository.save(parcel);
        trackingHistoryRepository.save(tracking_history);
    }


}
