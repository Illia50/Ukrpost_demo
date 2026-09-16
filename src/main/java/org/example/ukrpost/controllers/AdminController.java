package org.example.ukrpost.controllers;

import org.example.ukrpost.services.AdminService;
import org.springframework.web.bind.annotation.*;
import org.example.ukrpost.dto.*;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/accounts/operators")
    public void createOperatorAccount (@RequestBody CreateOperatorAccountDTO dto) {
        adminService.createOperatorAccount(dto.username(), dto.role(), dto.locationId());
    }

    @PutMapping("/accounts/operators/{id}")
    public void updateOperatorAccount (@RequestBody CreateOperatorAccountDTO dto, @PathVariable UUID id) {
        adminService.updateOperatorAccount(id, dto.username(), dto.role(), dto.locationId());
    }

    @DeleteMapping("/accounts/operators/{id}")
    public void deleteOperatorAccount (@PathVariable UUID id) {
        adminService.deleteOperatorAccount(id);
    }

    @PostMapping ("/accounts/drivers")
    public void createDriverAccount (@RequestBody CreateDriverAccountDTO dto) {
        adminService.createDriverAccount(dto.username(), dto.role(), dto.truckId());
    }

    @PutMapping("/accounts/drivers/{id}")
    public void updateDriverAccount (@RequestBody CreateDriverAccountDTO dto, @PathVariable UUID id) {
        adminService.updateDriverAccount(id, dto.username(), dto.role(), dto.truckId());
    }

    @DeleteMapping("/accounts/drivers/{id}")
    public void deleteDriverAccount (@PathVariable UUID id) {
        adminService.deleteDriverAccount(id);
    }

    @PostMapping("/trucks")
    public void createTruck (@RequestBody CreateTruckDTO dto){
        adminService.createTruck(dto.brand(), dto.model(), dto.numberPlate());
    }

    @PutMapping("/trucks/{id}")
    public void updateTruck (@RequestBody CreateTruckDTO dto, @PathVariable UUID id){
        adminService.updateTruck(id, dto.brand(), dto.model(), dto.numberPlate());
    }
    @DeleteMapping("/trucks/{id}")
    public void deleteTruck(@PathVariable UUID id){
        adminService.deleteTruck(id);
    }

    @PostMapping("/locations")
    public void createLocation (@RequestBody CreateLocationDTO dto){
        adminService.createLocation(dto.name(), dto.location());
    }

    @PutMapping("/locations/{id}")
    public void updateLocation (@RequestBody CreateLocationDTO dto, @PathVariable UUID id){
        adminService.updateLocation(id, dto.name(), dto.location());
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation (@PathVariable UUID id){
        adminService.deleteLocation(id);
    }
}
