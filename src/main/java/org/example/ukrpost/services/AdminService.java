package org.example.ukrpost.services;

import org.example.ukrpost.entity.DriverAccount;
import org.example.ukrpost.entity.OperatorAccount;
import org.example.ukrpost.entity.ParcelLocation;
import org.example.ukrpost.entity.Truck;
import org.example.ukrpost.repository.DriverAccountRepository;
import org.example.ukrpost.repository.OperatorAccountRepository;
import org.example.ukrpost.repository.ParcelLocationRepository;
import org.example.ukrpost.repository.TruckRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {
    private final OperatorAccountRepository operatorAccountRepository;
    private final DriverAccountRepository driverAccountRepository;
    private final ParcelLocationRepository parcelLocationRepository;
    private final TruckRepository truckRepository;
    public AdminService(OperatorAccountRepository operatorAccountRepository, DriverAccountRepository driverAccountRepository, ParcelLocationRepository parcelLocationRepository, TruckRepository truckRepository) {
        this.operatorAccountRepository = operatorAccountRepository;
        this.driverAccountRepository = driverAccountRepository;
        this.parcelLocationRepository = parcelLocationRepository;
        this.truckRepository = truckRepository;
    }

    public void createOperatorAccount (String username, String role, UUID locationId) {
        OperatorAccount operatorAccount = new OperatorAccount();
        operatorAccount.setUsername(username);
        operatorAccount.setRole(role);
        operatorAccount.setLocation(parcelLocationRepository.findById(locationId).orElseThrow(() -> new RuntimeException()));
        operatorAccountRepository.save(operatorAccount);
    }

    public void updateOperatorAccount (UUID id, String username, String role, UUID locationId) {
        OperatorAccount operatorAccount = operatorAccountRepository.findById(id).orElseThrow();
        operatorAccount.setUsername(username);
        operatorAccount.setRole(role);
        operatorAccount.setLocation(parcelLocationRepository.findById(locationId).orElseThrow(() -> new RuntimeException()));
        operatorAccountRepository.save(operatorAccount);
    }

    public void deleteOperatorAccount (UUID id) {
        operatorAccountRepository.deleteById(id);
    }

    public void createDriverAccount (String username, String role, UUID truckId) {
        DriverAccount driverAccount = new DriverAccount();
        driverAccount.setUsername(username);
        driverAccount.setRole(role);
        driverAccount.setTruck(truckRepository.findById(truckId).orElseThrow(() -> new RuntimeException()));
        driverAccountRepository.save(driverAccount);
    }

    public void updateDriverAccount (UUID id, String username, String role, UUID truckId) {
        DriverAccount driverAccount = driverAccountRepository.findById(id).orElseThrow();
        driverAccount.setUsername(username);
        driverAccount.setRole(role);
        driverAccount.setTruck(truckRepository.findById(truckId).orElseThrow(() -> new RuntimeException()));
        driverAccountRepository.save(driverAccount);
    }

    public void deleteDriverAccount (UUID id) {
        driverAccountRepository.deleteById(id);
    }

    public void createTruck (String brand, String model, String numberPlate){
        Truck truck = new Truck();
        truck.setBrand(brand);
        truck.setModel(model);
        truck.setNumberPlate(numberPlate);
        truckRepository.save(truck);
    }

    public void updateTruck (UUID id, String brand, String model, String numberPlate){
        Truck truck = truckRepository.findById(id).orElseThrow();
        truck.setBrand(brand);
        truck.setModel(model);
        truck.setNumberPlate(numberPlate);
        truckRepository.save(truck);
    }

    public void deleteTruck(UUID id){
        truckRepository.deleteById(id);
    }

    public void createLocation (String name, String address){
        ParcelLocation location = new ParcelLocation();
        location.setName(name);
        location.setLocation(address);
        parcelLocationRepository.save(location);
    }

    public void updateLocation (UUID id, String name, String address){
        ParcelLocation location = parcelLocationRepository.findById(id).orElseThrow();
        location.setName(name);
        location.setLocation(address);
        parcelLocationRepository.save(location);
    }

    public void deleteLocation (UUID id){
        parcelLocationRepository.deleteById(id);
    }

}
