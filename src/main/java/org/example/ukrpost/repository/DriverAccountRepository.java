package org.example.ukrpost.repository;

import org.example.ukrpost.entity.DriverAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverAccountRepository extends JpaRepository<DriverAccount, UUID> {
    DriverAccount findAccountById (UUID id);
    Optional<DriverAccount> findByUsername(String username);
}