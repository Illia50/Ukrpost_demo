package org.example.ukrpost;

import jakarta.transaction.Transactional;
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
        operatorAccount.setId(UUID.randomUUID());
        operatorAccount.setUsername(username);
        operatorAccount.setRole(role);

        Parcel_location location = parcelLocationRepository.findById(locationId).orElseThrow(
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
        Parcel_location location = parcelLocationRepository.findById(locationId).orElseThrow(
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
