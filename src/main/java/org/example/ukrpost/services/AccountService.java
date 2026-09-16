package org.example.ukrpost.services;

import jakarta.transaction.Transactional;
import org.example.ukrpost.entity.OperatorAccount;
import org.example.ukrpost.repository.OperatorAccountRepository;
import org.example.ukrpost.entity.ParcelLocation;
import org.example.ukrpost.repository.ParcelLocationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    private final OperatorAccountRepository operatorAccountRepository;
    private final ParcelLocationRepository parcelLocationRepository;
    public AccountService (OperatorAccountRepository operatorAccountRepository, ParcelLocationRepository parcelLocationRepository) {
        this.operatorAccountRepository = operatorAccountRepository;
        this.parcelLocationRepository = parcelLocationRepository;
    }

    @Transactional
    public void createAccount (String username, String role, UUID locationId){
        OperatorAccount operatorAccount = new OperatorAccount();
        operatorAccount.setUsername(username);
        operatorAccount.setRole(role);
        ParcelLocation location = parcelLocationRepository.findById(locationId).orElseThrow(
                () -> new RuntimeException("Such department doesn't exist")
        );
        operatorAccount.setLocation(location);
        operatorAccountRepository.save(operatorAccount);
    }

    @Transactional
    public void updateAccount (UUID accountId, String username, String role, UUID locationId){
        OperatorAccount operatorAccount = operatorAccountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account with ID " + accountId + " not found.")
        );
        operatorAccount.setUsername(username);
        operatorAccount.setRole(role);
        ParcelLocation location = parcelLocationRepository.findById(locationId).orElseThrow(
                () -> new RuntimeException("Such department doesn't exist")
        );
        operatorAccount.setLocation(location);
        operatorAccountRepository.save(operatorAccount);
    }

    @Transactional
    public void deleteAccount (UUID accountId) {
        if (operatorAccountRepository.existsById(accountId)) operatorAccountRepository.deleteById(accountId);
        else throw new RuntimeException("Account with ID " + accountId + " not found.");
    }


}
