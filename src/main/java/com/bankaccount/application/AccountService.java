package com.bankaccount.application;


import com.bankaccount.domain.model.InvestmentRiskLevel;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.Account.AccountStatus;
import com.bankaccount.domain.model.Account.InsufficientFundsException;
import com.bankaccount.domain.model.CurrentAccount;
import com.bankaccount.domain.model.InvestmentAccount;
import com.bankaccount.domain.model.SavingsAccount;
import com.bankaccount.domain.ports.AccountRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AccountService {
    
    private final AccountRepository accountRepository;
    
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public Account createSavingsAccount(
            @NotNull UUID id,
            @NotBlank String accountNumber,
            @NotBlank String accountHolder,
            @NotNull @Valid BigDecimal initialBalance,
            BigDecimal interestRate) {
        
        validateAccountNumberNotExists(accountNumber);
        validateInitialBalance(initialBalance);
        
        SavingsAccount account = new SavingsAccount(
            id, accountNumber, accountHolder, initialBalance, interestRate
        );
        return accountRepository.save(account);
    }
    
    public Account createCurrentAccount(
            @NotNull UUID id,
            @NotBlank String accountNumber,
            @NotBlank String accountHolder,
            @NotNull @Valid BigDecimal initialBalance,
            BigDecimal overdraftLimit) {
        
        validateAccountNumberNotExists(accountNumber);
        validateInitialBalance(initialBalance);
        
        CurrentAccount account = new CurrentAccount(
            id, accountNumber, accountHolder, initialBalance, overdraftLimit
        );
        return accountRepository.save(account);
    }
    
    public Account createInvestmentAccount(
            @NotNull UUID id,
            @NotBlank String accountNumber,
            @NotBlank String accountHolder,
            @NotNull @Valid BigDecimal initialBalance,
            BigDecimal interestRate,
            BigDecimal minimumBalance,
            InvestmentAccount.InvestmentRiskLevel riskLevel) {
        
        validateAccountNumberNotExists(accountNumber);
        validateInitialBalance(initialBalance);
        
        InvestmentAccount account = new InvestmentAccount(
            id, accountNumber, accountHolder, initialBalance,
            interestRate, minimumBalance, riskLevel
        );
        return accountRepository.save(account);
    }
    
    public void deposit(@NotNull UUID accountId, @NotNull @Valid BigDecimal amount) {
        Account account = findAccountById(accountId);
        account.deposit(amount);
        accountRepository.save(account);
    }
    
    public void withdraw(@NotNull UUID accountId, @NotNull @Valid BigDecimal amount) {
        Account account = findAccountById(accountId);
        account.withdraw(amount);
        accountRepository.save(account);
    }
    
    public void transfer(
            @NotNull UUID sourceAccountId,
            @NotNull UUID targetAccountId,
            @NotNull @Valid BigDecimal amount) {
        
        if (sourceAccountId.equals(targetAccountId)) {
            throw new IllegalArgumentException(
                "No se puede transferir a la misma cuenta origen y destino"
            );
        }
        
        Account sourceAccount = findAccountById(sourceAccountId);
        Account targetAccount = findAccountById(targetAccountId);
        
        sourceAccount.transfer(targetAccount, amount);
        
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }
    
    public Account getAccountById(@NotNull UUID id) {
        return findAccountById(id);
    }
    
    public Account getAccountByNumber(@NotBlank String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
            .orElseThrow(() -> new AccountNotFoundException(
                "Cuenta no encontrada con número: " + accountNumber
            ));
    }
    
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    public List<Account> getAccountsByHolder(@NotBlank String holderName) {
        return accountRepository.findByAccountHolderContainingIgnoreCase(holderName);
    }
    
    public List<Account> getAccountsByStatus(@NotNull AccountStatus status) {
        return accountRepository.findByStatus(status);
    }
    
    public void deactivateAccount(@NotNull UUID accountId) {
        Account account = findAccountById(accountId);
        account.setStatus(AccountStatus.INACTIVE);
        account.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(account);
    }
    
    public void activateAccount(@NotNull UUID accountId) {
        Account account = findAccountById(accountId);
        account.setStatus(AccountStatus.ACTIVE);
        account.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(account);
    }
    
    public void deleteAccount(@NotNull UUID accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException(
                "Cuenta no encontrada con ID: " + accountId
            );
        }
        accountRepository.deleteById(accountId);
    }
    
    public long getTotalAccounts() {
        return accountRepository.count();
    }
    
    private Account findAccountById(UUID id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException(
                "Cuenta no encontrada con ID: " + id
            ));
    }
    
    private void validateAccountNumberNotExists(String accountNumber) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException(
                "Ya existe una cuenta con el número: " + accountNumber
            );
        }
    }
    
    private void validateInitialBalance(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                "El saldo inicial no puede ser negativo"
            );
        }
    }
    
    public static class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }
}