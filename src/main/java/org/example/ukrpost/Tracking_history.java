package org.example.ukrpost;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Tracking_history {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "parcel_id")

    private Parcel parcel;
    private String status;
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Parcel_location location;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private OperatorAccount operatorAccount;

    public void setId (UUID id){
        this.id = id;
    }

    public void setParcel (Parcel parcel){
        this.parcel = parcel;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public void setUpdatedAt (LocalDateTime updated_at){
        this.updated_at = updated_at;
    }

    public void setLocation (Parcel_location location){
        this.location = location;
    }

    public void setTruck (Truck truck){
        this.truck = truck;
    }

    public void setAccount (OperatorAccount operatorAccount){
        this.operatorAccount = operatorAccount;
    }

    public UUID getId () {
        return this.id;
    }

    public Parcel getParcelId () {
        return this.parcel;
    }

    public String getStatus(){
        return this.status;
    }

    public LocalDateTime getUpdatedAt () {
        return this.updated_at;
    }

    public Parcel_location getLocation () {
        return this.location;
    }

    public Truck getTruck () {
        return this.truck;
    }

    public OperatorAccount getAccount () {
        return this.operatorAccount;
    }

}
