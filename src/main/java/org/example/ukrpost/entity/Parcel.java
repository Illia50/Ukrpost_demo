package org.example.ukrpost.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Data
public class Parcel {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String trackingNumber;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "current_location_id")
    private ParcelLocation parcelLocation;

    @ManyToOne
    @JoinColumn(name = "current_truck_id")
    private Truck truck;
}
