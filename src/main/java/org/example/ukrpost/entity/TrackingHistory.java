package org.example.ukrpost.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class TrackingHistory {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "parcel_id")

    private Parcel parcel;
    private String status;
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private ParcelLocation location;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private OperatorAccount operatorAccount;

}
