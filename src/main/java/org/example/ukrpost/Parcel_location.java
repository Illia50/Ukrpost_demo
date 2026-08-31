package org.example.ukrpost;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Parcel_location {

    @Id
    private UUID id;
    private String name;
    private String location;

    public void setId (UUID id){
        this.id = id;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setLocation (String location){
        this.location = location;
    }

    public UUID getId (){
        return this.id;
    }

    public String getName (){
        return this.name;
    }

    public String getLocation (){
        return this.location;
    }
}
