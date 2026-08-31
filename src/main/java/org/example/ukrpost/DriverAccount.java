package org.example.ukrpost;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class DriverAccount {
    @Id
    private UUID id;
    private String username;
    private String role;
    @ManyToOne
    @JoinColumn(name = "truckId")
    private Truck truck;

    public void setId (UUID id) {
        this.id = id;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setRole (String role) {
        this.role = role;
    }

    public void setTruck (Truck truck) {
        this.truck = truck;
    }

    public UUID getId (){
        return this.id;
    }

    public String getUsername (){
        return this.username;
    }

    public String getRole (){
        return this.role;
    }

    public Truck getTruck (){
        return this.truck;
    }
}
