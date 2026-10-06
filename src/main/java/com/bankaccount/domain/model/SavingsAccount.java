package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
    @NotNull
    @Positive
    private BigDecimal interestRate;

    public SavingsAccount() {
        super();
        this.interestRate = BigDecimal.ZERO;
    }

    public SavingsAccount(UUID id, String accountNumber, String accountHolder, BigDecimal balance,
                         LocalDateTime createdAt, LocalDateTime updatedAt, AccountStatus status,
                         BigDecimal interestRate) {
        super(id, accountNumber, accountHolder, balance, createdAt, updatedAt, status);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        setBalance(getBalance().add(amount));
        setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public void withdraw(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        if (getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        setBalance(getBalance().subtract(amount));
        setUpdatedAt(LocalDateTime.now());
    }

    public void applyInterest() {
        BigDecimal interest = getBalance().multiply(interestRate).divide(BigDecimal.valueOf(100));
        deposit(interest);
    }
}