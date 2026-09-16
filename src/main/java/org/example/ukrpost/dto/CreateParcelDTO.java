package org.example.ukrpost.dto;

import java.time.LocalDateTime;

public record CreateParcelDTO (String description, LocalDateTime time_now){}
