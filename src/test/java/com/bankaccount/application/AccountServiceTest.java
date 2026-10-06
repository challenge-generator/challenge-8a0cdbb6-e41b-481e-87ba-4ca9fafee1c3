package com.bankaccount.application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.SavingsAccount;
import com.bankaccount.domain.model.CurrentAccount;
import com.bankaccount.domain.ports.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para AccountService")
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    @DisplayName("Crear cuenta de ahorro exitosamente")
    @Disabled("Completar implementación")
    void shouldCreateSavingsAccountSuccessfully() {
        // Given: datos válidos para cuenta de ahorro
        String accountHolder = "Nuevo Cliente";
        BigDecimal initialBalance = new BigDecimal("1000.00");
        BigDecimal interestRate = new BigDecimal("0.05");
        
        when(accountRepository.save(any(SavingsAccount.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        // When: se crea la cuenta
        Account created = accountService.createSavingsAccount(accountHolder, initialBalance, interestRate);

        // Then: la cuenta se guarda y retorna con datos correctos
        assertNotNull(created);
        assertEquals(accountHolder, created.getAccountHolder());
        assertEquals(initialBalance, created.getBalance());
        verify(accountRepository, times(1)).save(any(SavingsAccount.class));
    }

    @Test
    @DisplayName("Crear cuenta corriente exitosamente")
    @Disabled("Completar implementación")
    void shouldCreateCurrentAccountSuccessfully() {
        // Given: datos válidos para cuenta corriente
        String accountHolder = "Empresa Test";
        BigDecimal initialBalance = new BigDecimal("2000.00");
        BigDecimal overdraftLimit = new BigDecimal("500.00");
        
        when(accountRepository.save(any(CurrentAccount.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        // When: se crea la cuenta
        Account created = accountService.createCurrentAccount(accountHolder, initialBalance, overdraftLimit);

        // Then: la cuenta se guarda y retorna con datos correctos
        assertNotNull(created);
        assertEquals(accountHolder, created.getAccountHolder());
        assertEquals(initialBalance, created.getBalance());
        verify(accountRepository, times(1)).save(any(CurrentAccount.class));
    }

    @Test
    @DisplayName("Depositar en cuenta existente")
    @Disabled("Completar implementación")
    void shouldDepositInExistingAccount() {
        // Given: una cuenta existente en el repositorio
        UUID accountId = UUID.randomUUID();
        SavingsAccount existingAccount = new SavingsAccount(
            accountId,
            "SAV-010",
            "Titular",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BigDecimal depositAmount = new BigDecimal("250.00");

        // When: se deposita
        Account result = accountService.deposit(accountId, depositAmount);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("750.00"), result.getBalance());
        verify(accountRepository, times(1)).findById(accountId);
        verify(accountRepository, times(1)).save(existingAccount);
    }

    @Test
    @DisplayName("Retirar de cuenta existente")
    @Disabled("Completar implementación")
    void shouldWithdrawFromExistingAccount() {
        // Given: una cuenta con saldo
        UUID accountId = UUID.randomUUID();
        SavingsAccount existingAccount = new SavingsAccount(
            accountId,
            "SAV-011",
            "Titular",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BigDecimal withdrawAmount = new BigDecimal("400.00");

        // When: se retira
        Account result = accountService.withdraw(accountId, withdrawAmount);

        // Then: el saldo disminuye
        assertEquals(new BigDecimal("600.00"), result.getBalance());
    }

    @Test
    @DisplayName("Transferir entre cuentas")
    @Disabled("Completar implementación")
    void shouldTransferBetweenAccounts() {
        // Given: cuenta origen y cuenta destino
        UUID sourceId = UUID.randomUUID();
        UUID targetId = UUID.randomUUID();
        
        SavingsAccount sourceAccount = new SavingsAccount(
            sourceId,
            "SAV-012",
            "Origen",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        
        SavingsAccount targetAccount = new SavingsAccount(
            targetId,
            "SAV-013",
            "Destino",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(sourceId)).thenReturn(Optional.of(sourceAccount));
        when(accountRepository.findById(targetId)).thenReturn(Optional.of(targetAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BigDecimal transferAmount = new BigDecimal("300.00");

        // When: se transfiere
        boolean result = accountService.transfer(sourceId, targetId, transferAmount);

        // Then: transferencia exitosa
        assertTrue(result);
        verify(accountRepository, times(2)).save(any(Account.class));
    }

    @Test
    @DisplayName("Fallar transferencia por cuenta origen no encontrada")
    @Disabled("Completar implementación")
    void shouldFailTransferWhenSourceAccountNotFound() {
        // Given: cuenta origen no existe
        UUID sourceId = UUID.randomUUID();
        UUID targetId = UUID.randomUUID();
        
        when(accountRepository.findById(sourceId)).thenReturn(Optional.empty());

        // When/Then: transferencia falla
        assertThrows(RuntimeException.class, () -> {
            accountService.transfer(sourceId, targetId, new BigDecimal("100.00"));
        });
    }

    @Test
    @DisplayName("Obtener cuenta por ID")
    @Disabled("Completar implementación")
    void shouldGetAccountById() {
        // Given: cuenta existente
        UUID accountId = UUID.randomUUID();
        SavingsAccount existingAccount = new SavingsAccount(
            accountId,
            "SAV-014",
            "Buscada",
            new BigDecimal("800.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));

        // When: se busca la cuenta
        Optional<Account> result = accountService.getAccountById(accountId);

        // Then: se encuentra la cuenta
        assertTrue(result.isPresent());
        assertEquals(accountId, result.get().getId());
    }

    @Test
    @DisplayName("Obtener todas las cuentas")
    @Disabled("Completar implementación")
    void shouldGetAllAccounts() {
        // Given: múltiples cuentas en el repositorio
        // When: se obtienen todas las cuentas
        // Then: se retornan todas
        verify(accountRepository, never()).findAll();
    }

    @Test
    @DisplayName("Depositar en cuenta inexistente debe fallar")
    @Disabled("Completar implementación")
    void shouldFailDepositWhenAccountNotFound() {
        // Given: cuenta no existe
        UUID accountId = UUID.randomUUID();
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // When/Then: depósito falla
        assertThrows(RuntimeException.class, () -> {
            accountService.deposit(accountId, new BigDecimal("100.00"));
        });
    }

    @Test
    @DisplayName("Retirar de cuenta inexistente debe fallar")
    @Disabled("Completar implementación")
    void shouldFailWithdrawWhenAccountNotFound() {
        // Given: cuenta no existe
        UUID accountId = UUID.randomUUID();
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // When/Then: retiro falla
        assertThrows(RuntimeException.class, () -> {
            accountService.withdraw(accountId, new BigDecimal("100.00"));
        });
    }

    @Test
    @DisplayName("Aplicar interés a cuenta de ahorro")
    @Disabled("Completar implementación")
    void shouldApplyInterestToSavingsAccount() {
        // Given: cuenta de ahorro
        UUID accountId = UUID.randomUUID();
        SavingsAccount savingsAccount = new SavingsAccount(
            accountId,
            "SAV-015",
            "Inversor",
            new BigDecimal("1000.00"),
            new BigDecimal("0.10")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(savingsAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When: se aplica interés
        Account result = accountService.applyInterest(accountId);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("1100.00"), result.getBalance());
    }
}