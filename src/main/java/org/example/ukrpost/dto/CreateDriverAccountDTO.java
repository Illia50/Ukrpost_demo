package org.example.ukrpost.dto;

import java.util.UUID;

public record CreateDriverAccountDTO (String username, String role, UUID truckId) {}