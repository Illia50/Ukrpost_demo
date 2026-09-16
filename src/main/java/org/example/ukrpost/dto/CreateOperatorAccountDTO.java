package org.example.ukrpost.dto;

import java.util.UUID;

public record CreateOperatorAccountDTO (String username, String role, UUID locationId) {}