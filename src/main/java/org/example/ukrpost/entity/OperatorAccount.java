package org.example.ukrpost.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatorAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String role;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private ParcelLocation location;
}
