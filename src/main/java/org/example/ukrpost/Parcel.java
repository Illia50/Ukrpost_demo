package org.example.ukrpost;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import java.util.UUID;
@Entity
public class Parcel {
    @Id
    private UUID id;
    private String trackingNumber;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "current_location_id")
    private Parcel_location parcelLocation;

    @ManyToOne
    @JoinColumn(name = "current_truck_id")
    private Truck truck;

    public void setId (UUID id){
        this.id = id;
    }

    public void setTrackingNumber (String trackingNumber){
        this.trackingNumber = trackingNumber;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public void setCurrentLocation (Parcel_location parcelLocation){
        this.parcelLocation = parcelLocation;
    }

    public void setCurrentTruck (Truck truck){
        this.truck = truck;
    }

    public UUID getId (){
        return this.id;
    }

    public String getTrackingNumber(){
        return this.trackingNumber;
    }

    public String getDescription (){
        return this.description;
    }

    public String getStatus (){
        return this.status;
    }

    public Parcel_location getCurrentLocation (){
        return this.parcelLocation;
    }

    public Truck getCurrentTruck (){
        return this.truck;
    }
}
