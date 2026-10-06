package com.bankaccount.domain.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas unitarias para el modelo de Account")
class AccountTest {

    @Test
    @DisplayName("Crear SavingsAccount con datos válidos")
    @Disabled("Completar implementación")
    void shouldCreateSavingsAccountWithValidData() {
        // Given: datos válidos para una cuenta de ahorro
        UUID id = UUID.randomUUID();
        String accountNumber = "SAV-001";
        String accountHolder = "Juan Pérez";
        BigDecimal initialBalance = new BigDecimal("1000.00");
        BigDecimal interestRate = new BigDecimal("0.05");

        // When: se crea la cuenta de ahorro
        SavingsAccount account = new SavingsAccount(id, accountNumber, accountHolder, initialBalance, interestRate);

        // Then: los valores se asignan correctamente
        assertEquals(id, account.getId());
        assertEquals(accountNumber, account.getAccountNumber());
        assertEquals(accountHolder, account.getAccountHolder());
        assertEquals(initialBalance, account.getBalance());
        assertEquals(interestRate, account.getInterestRate());
    }

    @Test
    @DisplayName("Crear CurrentAccount con datos válidos")
    @Disabled("Completar implementación")
    void shouldCreateCurrentAccountWithValidData() {
        // Given: datos válidos para una cuenta corriente
        UUID id = UUID.randomUUID();
        String accountNumber = "CUR-001";
        String accountHolder = "María García";
        BigDecimal initialBalance = new BigDecimal("500.00");
        BigDecimal overdraftLimit = new BigDecimal("200.00");

        // When: se crea la cuenta corriente
        CurrentAccount account = new CurrentAccount(id, accountNumber, accountHolder, initialBalance, overdraftLimit);

        // Then: los valores se asignan correctamente
        assertEquals(id, account.getId());
        assertEquals(accountNumber, account.getAccountNumber());
        assertEquals(accountHolder, account.getAccountHolder());
        assertEquals(initialBalance, account.getBalance());
        assertEquals(overdraftLimit, account.getOverdraftLimit());
    }

    @Test
    @DisplayName("Depósito exitoso en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldDepositSuccessfullyInSavingsAccount() {
        // Given: una cuenta de ahorro con saldo inicial
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-002",
            "Pedro López",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        BigDecimal depositAmount = new BigDecimal("500.00");

        // When: se realiza un depósito
        account.deposit(depositAmount);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("1500.00"), account.getBalance());
    }

    @Test
    @DisplayName("Retiro exitoso en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldWithdrawSuccessfullyInSavingsAccount() {
        // Given: una cuenta de ahorro con saldo suficiente
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-003",
            "Ana Martínez",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        BigDecimal withdrawAmount = new BigDecimal("300.00");

        // When: se realiza un retiro
        account.withdraw(withdrawAmount);

        // Then: el saldo disminuye
        assertEquals(new BigDecimal("700.00"), account.getBalance());
    }

    @Test
    @DisplayName("Retiro fallido por saldo insuficiente en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldFailWithdrawDueToInsufficientFundsInSavingsAccount() {
        // Given: una cuenta de ahorro con saldo limitado
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-004",
            "Carlos Ruiz",
            new BigDecimal("100.00"),
            new BigDecimal("0.05")
        );
        BigDecimal withdrawAmount = new BigDecimal("500.00");

        // When/Then: el retiro lanza InsufficientFundsException
        assertThrows(Account.InsufficientFundsException.class, () -> {
            account.withdraw(withdrawAmount);
        });
    }

    @Test
    @DisplayName("Transferencia exitosa entre cuentas")
    @Disabled("Completar implementación")
    void shouldTransferSuccessfullyBetweenAccounts() {
        // Given: dos cuentas con saldo
        SavingsAccount sourceAccount = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-005",
            "Origen",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        SavingsAccount targetAccount = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-006",
            "Destino",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );
        BigDecimal transferAmount = new BigDecimal("300.00");

        // When: se realiza la transferencia
        sourceAccount.transfer(targetAccount, transferAmount);

        // Then: ambos saldos se actualizan correctamente
        assertEquals(new BigDecimal("700.00"), sourceAccount.getBalance());
        assertEquals(new BigDecimal("800.00"), targetAccount.getBalance());
    }

    @Test
    @DisplayName("Aplicar interés en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldApplyInterestToSavingsAccount() {
        // Given: una cuenta de ahorro con tasa de interés
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-007",
            "Inversor",
            new BigDecimal("1000.00"),
            new BigDecimal("0.10")
        );

        // When: se aplica el interés
        account.applyInterest();

        // Then: el saldo aumenta en un 10%
        assertEquals(new BigDecimal("1100.00"), account.getBalance());
    }

    @Test
    @DisplayName("Depósito exitoso en CurrentAccount")
    @Disabled("Completar implementación")
    void shouldDepositSuccessfullyInCurrentAccount() {
        // Given: una cuenta corriente
        CurrentAccount account = new CurrentAccount(
            UUID.randomUUID(),
            "CUR-002",
            "Empresa SA",
            new BigDecimal("1000.00"),
            new BigDecimal("500.00")
        );
        BigDecimal depositAmount = new BigDecimal("200.00");

        // When: se realiza un depósito
        account.deposit(depositAmount);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("1200.00"), account.getBalance());
    }

    @Test
    @DisplayName("Retiro con overdraft en CurrentAccount")
    @Disabled("Completar implementación")
    void shouldWithdrawWithOverdraftInCurrentAccount() {
        // Given: una cuenta corriente con overdraft
        CurrentAccount account = new CurrentAccount(
            UUID.randomUUID(),
            "CUR-003",
            "Negocios",
            new BigDecimal("100.00"),
            new BigDecimal("200.00")
        );
        BigDecimal withdrawAmount = new BigDecimal("250.00");

        // When: se realiza un retiro que usa el overdraft
        account.withdraw(withdrawAmount);

        // Then: el saldo puede quedar negativo dentro del límite
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account.getBalance().compareTo(new BigDecimal("-200.00")) >= 0);
    }

    @Test
    @DisplayName("Validar que el depósito no acepta montos negativos")
    @Disabled("Completar implementación")
    void shouldNotAcceptNegativeDepositAmount() {
        // Given: una cuenta de ahorro
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-008",
            "Test",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );

        // When/Then: depósito con monto negativo lanza excepción
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(new BigDecimal("-100.00"));
        });
    }

    @Test
    @DisplayName("Validar que el retiro no acepta montos negativos")
    @Disabled("Completar implementación")
    void shouldNotAcceptNegativeWithdrawAmount() {
        // Given: una cuenta de ahorro
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-009",
            "Test",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );

        // When/Then: retiro con monto negativo lanza excepción
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(new BigDecimal("-50.00"));
        });
    }
}