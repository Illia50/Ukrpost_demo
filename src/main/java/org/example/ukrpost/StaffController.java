package org.example.ukrpost;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/parcel")
public class StaffController {
    private ParcelService parcelService;
    public StaffController (ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    public record CreateParcelDTO(String description, LocalDateTime time_now){}
    @PostMapping("/create")
    public void createParcel (@RequestBody CreateParcelDTO dto){
        parcelService.createParcel(dto.description(), dto.time_now());
    }

}
