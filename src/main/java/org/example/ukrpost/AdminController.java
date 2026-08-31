package org.example.ukrpost;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AdminController {
    private OperatorAccountRepository operatorAccountRepository;
    private DriverAccountRepository driverAccountRepository;
    private ParcelLocationRepository parcelLocationRepository;
    private TruckRepository truckRepository;
    public AdminController (OperatorAccountRepository operatorAccountRepository, DriverAccountRepository driverAccountRepository, ParcelLocationRepository parcelLocationRepository, TruckRepository truckRepository) {
        this.operatorAccountRepository = operatorAccountRepository;
        this.driverAccountRepository = driverAccountRepository;
        this.parcelLocationRepository = parcelLocationRepository;
        this.truckRepository = truckRepository;
    }

    public record CreateOperatorAccountDTO (String username, String role, UUID locationId) {}
    public record CreateDriverAccountDTO (String username, String role, UUID truckId) {}
    public record CreateTruckDTO (String brand, String model, String numberPlate) {}
    public record CreateLocationDTO (String name, String location) {}
    @PostMapping ("/accounts/operators")
    public void createOperatorAccount (@RequestBody CreateOperatorAccountDTO dto) {
        OperatorAccount operatorAccount = new OperatorAccount();
        operatorAccount.setId(UUID.randomUUID());
        operatorAccount.setUsername(dto.username());
        operatorAccount.setRole(dto.role());
        operatorAccount.setLocation(parcelLocationRepository.findById(dto.locationId()).orElseThrow(() -> new RuntimeException()));
        operatorAccountRepository.save(operatorAccount);
    }

    @PutMapping("/accounts/operators/{id}")
    public void updateOperatorAccount (@RequestBody CreateOperatorAccountDTO dto, @PathVariable UUID id) {
        OperatorAccount operatorAccount = operatorAccountRepository.findById(id).orElseThrow();
        operatorAccount.setUsername(dto.username());
        operatorAccount.setRole(dto.role());
        operatorAccount.setLocation(parcelLocationRepository.findById(dto.locationId()).orElseThrow(() -> new RuntimeException()));
        operatorAccountRepository.save(operatorAccount);
    }

    @DeleteMapping("/accounts/operators/{id}")
    public void deleteOperatorAccount (@PathVariable UUID id) {operatorAccountRepository.deleteById(id);
    }

    @PostMapping ("/accounts/drivers")
    public void createDriverAccount (@RequestBody CreateDriverAccountDTO dto) {
        DriverAccount driverAccount = new DriverAccount();
        driverAccount.setId(UUID.randomUUID());
        driverAccount.setUsername(dto.username());
        driverAccount.setRole(dto.role());
        driverAccount.setTruck(truckRepository.findById(dto.truckId()).orElseThrow(() -> new RuntimeException()));
        driverAccountRepository.save(driverAccount);
    }

    @PutMapping("/accounts/drivers/{id}")
    public void updateDriverAccount (@RequestBody CreateDriverAccountDTO dto, @PathVariable UUID id) {
        DriverAccount driverAccount = driverAccountRepository.findById(id).orElseThrow();
        driverAccount.setUsername(dto.username());
        driverAccount.setRole(dto.role());
        driverAccount.setTruck(truckRepository.findById(dto.truckId()).orElseThrow(() -> new RuntimeException()));
        driverAccountRepository.save(driverAccount);
    }

    @DeleteMapping("/accounts/drivers/{id}")
    public void deleteDriverAccount (@PathVariable UUID id) {
        driverAccountRepository.deleteById(id);
    }

    @PostMapping("/trucks")
    public void createTruck (@RequestBody CreateTruckDTO dto){
        Truck truck = new Truck();
        truck.setId(UUID.randomUUID());
        truck.setBrand(dto.brand());
        truck.setModel(dto.model());
        truck.setNumber_plate(dto.numberPlate());
        truckRepository.save(truck);
    }

    @DeleteMapping("/trucks/{id}")
    public void deleteTruck(@PathVariable UUID id){
        truckRepository.deleteById(id);
    }

    @PostMapping("/locations")
    public void createLocation (@RequestBody CreateLocationDTO dto){
        Parcel_location location = new Parcel_location();
        location.setId(UUID.randomUUID());
        location.setName(dto.name());
        location.setLocation(dto.location());
        parcelLocationRepository.save(location);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation (@PathVariable UUID id){
        parcelLocationRepository.deleteById(id);
    }


}
