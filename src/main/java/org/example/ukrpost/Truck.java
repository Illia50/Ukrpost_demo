package org.example.ukrpost;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

import java.util.UUID;
@Entity
public class Truck {
    @Id
    private UUID id;
    private String numberPlate;
    private String brand;
    private String model;

    public void setId (UUID id){
        this.id = id;
    }

    public void setNumber_plate (String numberPlate){
        this.numberPlate = numberPlate;
    }

    public void setBrand (String brand){
        this.brand = brand;
    }

    public void setModel (String model){
        this.model = model;
    }

    public UUID getId (){
        return this.id;
    }

    public String getNumber_plate (){
        return this.numberPlate;
    }

    public String getBrand (){
        return this.brand;
    }

    public String getModel (){
        return this.model;
    }
}
