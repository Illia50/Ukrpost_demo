package org.example.ukrpost.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class DriverAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String role;
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;
}
