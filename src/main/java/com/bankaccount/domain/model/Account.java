package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Account {
    @NotNull
    private UUID id;

    @NotNull
    @Size(min = 5, max = 50)
    private String accountNumber;

    @NotNull
    @Size(min = 3, max = 100)
    private String accountHolder;

    @NotNull
    @Positive
    private BigDecimal balance;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private AccountStatus status;

    public enum AccountStatus {
        ACTIVE, BLOCKED, CLOSED
    }

    public abstract void deposit(@NotNull @Positive BigDecimal amount);

    public abstract void withdraw(@NotNull @Positive BigDecimal amount);

    public void transfer(@NotNull Account targetAccount, @NotNull @Positive BigDecimal amount) {
        if (this.status != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot transfer from a non-active account");
        }
        if (targetAccount.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot transfer to a non-active account");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds for transfer");
        }

        this.withdraw(amount);
        targetAccount.deposit(amount);
        this.updatedAt = LocalDateTime.now();
        targetAccount.setUpdatedAt(LocalDateTime.now());
    }

    protected void validatePositiveAmount(@NotNull @Positive BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}