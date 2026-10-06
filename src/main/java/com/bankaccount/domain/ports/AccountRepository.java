package com.bankaccount.domain.ports;

import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.Account.AccountStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    
    Account save(Account account);
    
    Optional<Account> findById(UUID id);
    
    Optional<Account> findByAccountNumber(String accountNumber);
    
    List<Account> findAll();
    
    List<Account> findByStatus(AccountStatus status);
    
    List<Account> findByAccountHolder(String accountHolder);
    
    void deleteById(UUID id);
    
    boolean existsByAccountNumber(String accountNumber);
    
    long count();
    
    List<Account> findByAccountHolderContainingIgnoreCase(String partialName);
}