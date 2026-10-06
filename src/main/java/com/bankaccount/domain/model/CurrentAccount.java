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
public class CurrentAccount extends Account {
    @NotNull
    @Positive
    private BigDecimal overdraftLimit;

    public CurrentAccount() {
        super();
        this.overdraftLimit = BigDecimal.ZERO;
    }

    public CurrentAccount(UUID id, String accountNumber, String accountHolder, BigDecimal balance,
                         LocalDateTime createdAt, LocalDateTime updatedAt, AccountStatus status,
                         BigDecimal overdraftLimit) {
        super(id, accountNumber, accountHolder, balance, createdAt, updatedAt, status);
        this.overdraftLimit = overdraftLimit;
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
        BigDecimal availableBalance = getBalance().add(overdraftLimit);
        if (availableBalance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds including overdraft limit");
        }
        setBalance(getBalance().subtract(amount));
        setUpdatedAt(LocalDateTime.now());
    }
}