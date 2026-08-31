package org.example.ukrpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OperatorAccountRepository extends JpaRepository<OperatorAccount, UUID> {
    OperatorAccount findAccountById (UUID id);
    Optional<OperatorAccount> findByUsername(String username);
}