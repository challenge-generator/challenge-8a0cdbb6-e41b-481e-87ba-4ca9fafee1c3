package com.bankaccount.infrastructure.controllers;

import com.bankaccount.application.AccountService;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.Account.AccountStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        Account createdAccount = accountService.createAccount(
            request.accountNumber(),
            request.accountHolder(),
            request.accountType(),
            request.initialBalance()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        return accountService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        return accountService.findByAccountNumber(accountNumber)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/holder/{accountHolder}")
    public ResponseEntity<List<Account>> getAccountsByHolder(@PathVariable String accountHolder) {
        List<Account> accounts = accountService.findByAccountHolder(accountHolder);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Account>> getAccountsByStatus(@PathVariable AccountStatus status) {
        List<Account> accounts = accountService.findByStatus(status);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(
            @PathVariable UUID id,
            @Valid @RequestBody TransactionRequest request) {
        return accountService.findById(id)
            .map(account -> {
                accountService.deposit(account, request.amount());
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(
            @PathVariable UUID id,
            @Valid @RequestBody TransactionRequest request) {
        return accountService.findById(id)
            .map(account -> {
                accountService.withdraw(account, request.amount());
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/transfer")
    public ResponseEntity<Account> transfer(
            @PathVariable UUID id,
            @Valid @RequestBody TransferRequest request) {
        return accountService.findById(id)
            .map(sourceAccount -> {
                return accountService.findByAccountNumber(request.targetAccountNumber())
                    .map(targetAccount -> {
                        accountService.transfer(sourceAccount, targetAccount, request.amount());
                        return ResponseEntity.ok(sourceAccount);
                    })
                    .orElse(ResponseEntity.notFound().build());
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/apply-interest")
    public ResponseEntity<Account> applyInterest(@PathVariable UUID id) {
        return accountService.findById(id)
            .map(account -> {
                accountService.applyInterest(account);
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        return accountService.findById(id)
            .map(account -> {
                accountService.deleteAccount(account);
                return ResponseEntity.noContent().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Account> updateStatus(
            @PathVariable UUID id,
            @Valid @RequestBody StatusUpdateRequest request) {
        return accountService.findById(id)
            .map(account -> {
                accountService.updateStatus(account, request.status());
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/holder/{accountHolder}/total-balance")
    public ResponseEntity<Map<String, BigDecimal>> getTotalBalance(
            @PathVariable String accountHolder) {
        BigDecimal total = accountService.getTotalBalanceByAccountHolder(accountHolder);
        return ResponseEntity.ok(Map.of("totalBalance", total));
    }

    public record CreateAccountRequest(
        @NotBlank String accountNumber,
        @NotBlank String accountHolder,
        @NotBlank String accountType,
        @Positive BigDecimal initialBalance
    ) {}

    public record TransactionRequest(@NotNull @Positive BigDecimal amount) {}

    public record TransferRequest(
        @NotBlank String targetAccountNumber,
        @NotNull @Positive BigDecimal amount
    ) {}

    public record StatusUpdateRequest(@NotNull AccountStatus status) {}
}