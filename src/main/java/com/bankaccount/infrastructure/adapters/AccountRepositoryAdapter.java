package com.bankaccount.infrastructure.adapters;


import com.bankaccount.domain.model.AccountStatus;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.ports.AccountRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountRepositoryAdapter implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account = createNewAccount(account);
        } else {
            account = updateExistingAccount(account);
        }
        return account;
    }

    private Account createNewAccount(Account account) {
        entityManager.persist(account);
        entityManager.flush();
        entityManager.refresh(account);
        return account;
    }

    private Account updateExistingAccount(Account account) {
        account.setUpdatedAt(LocalDateTime.now());
        return entityManager.merge(account);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        Account account = entityManager.find(Account.class, id);
        return Optional.ofNullable(account);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber", Account.class);
        query.setParameter("accountNumber", accountNumber);
        List<Account> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a", Account.class);
        return query.getResultList();
    }

    @Override
    public void delete(Account account) {
        if (entityManager.contains(account)) {
            entityManager.remove(account);
        } else {
            entityManager.remove(entityManager.merge(account));
        }
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(a) FROM Account a WHERE a.accountNumber = :accountNumber", Long.class);
        query.setParameter("accountNumber", accountNumber);
        return query.getSingleResult() > 0;
    }

    @Override
    public List<Account> findByAccountHolder(String accountHolder) {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a WHERE a.accountHolder = :accountHolder", Account.class);
        query.setParameter("accountHolder", accountHolder);
        return query.getResultList();
    }

    @Override
    public List<Account> findByStatus(Account.AccountStatus status) {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a WHERE a.status = :status", Account.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public BigDecimal getTotalBalanceByAccountHolder(String accountHolder) {
        TypedQuery<BigDecimal> query = entityManager.createQuery(
            "SELECT COALESCE(SUM(a.balance), 0) FROM Account a WHERE a.accountHolder = :accountHolder",
            BigDecimal.class);
        query.setParameter("accountHolder", accountHolder);
        return query.getSingleResult();
    }
}