package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

public class InvestmentAccount extends Account {
    
    private BigDecimal interestRate;
    private BigDecimal minimumBalance;
    private InvestmentRiskLevel riskLevel;
    private LocalDateTime lastInterestCalculation;
    private boolean compoundInterest;
    
    public enum InvestmentRiskLevel {
        LOW, MEDIUM, HIGH
    }
    
    public InvestmentAccount() {
        super();
        this.riskLevel = InvestmentRiskLevel.LOW;
        this.compoundInterest = true;
        this.lastInterestCalculation = LocalDateTime.now();
    }
    
    public InvestmentAccount(UUID id, String accountNumber, String accountHolder, 
                             BigDecimal balance, BigDecimal interestRate, 
                             BigDecimal minimumBalance, InvestmentRiskLevel riskLevel) {
        super(id, accountNumber, accountHolder, balance, LocalDateTime.now(), 
              LocalDateTime.now(), AccountStatus.ACTIVE);
        this.interestRate = interestRate != null ? interestRate : new BigDecimal("0.045");
        this.minimumBalance = minimumBalance != null ? minimumBalance : new BigDecimal("1000.00");
        this.riskLevel = riskLevel != null ? riskLevel : InvestmentRiskLevel.LOW;
        this.compoundInterest = true;
        this.lastInterestCalculation = LocalDateTime.now();
    }
    
    @Override
    public void deposit(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        validateAccountIsActive();
        
        BigDecimal newBalance = getBalance().add(amount);
        setBalance(newBalance);
        setUpdatedAt(LocalDateTime.now());
        
        if (newBalance.compareTo(minimumBalance) >= 0 && !compoundInterest) {
            applyInterest();
        }
    }
    
    @Override
    public void withdraw(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        validateAccountIsActive();
        
        BigDecimal availableBalance = calculateAvailableBalance();
        if (availableBalance.compareTo(amount) < 0) {
            throw new InsufficientFundsException(
                "Fondos insuficientes para retiro. Disponible: " + availableBalance + 
                ", solicitado: " + amount
            );
        }
        
        BigDecimal newBalance = getBalance().subtract(amount);
        setBalance(newBalance);
        setUpdatedAt(LocalDateTime.now());
        
        if (newBalance.compareTo(minimumBalance) < 0) {
            applyPenalty();
        }
    }
    
    public void applyInterest() {
        if (getStatus() != AccountStatus.ACTIVE) {
            return;
        }
        
        BigDecimal currentBalance = getBalance();
        BigDecimal interest = currentBalance.multiply(interestRate)
            .divide(new BigDecimal("12"), RoundingMode.HALF_UP);
        
        BigDecimal newBalance = currentBalance.add(interest);
        setBalance(newBalance);
        setUpdatedAt(LocalDateTime.now());
        lastInterestCalculation = LocalDateTime.now();
    }
    
    public void applyCompoundInterest(int months) {
        if (!compoundInterest || getStatus() != AccountStatus.ACTIVE) {
            return;
        }
        
        BigDecimal currentBalance = getBalance();
        BigDecimal monthlyRate = interestRate.divide(new BigDecimal("12"), 
            RoundingMode.HALF_UP);
        
        BigDecimal compoundFactor = new BigDecimal("1").add(monthlyRate);
        BigDecimal compoundedBalance = currentBalance;
        
        for (int i = 0; i < months; i++) {
            compoundedBalance = compoundedBalance.multiply(compoundFactor);
        }
        
        BigDecimal interestEarned = compoundedBalance.subtract(currentBalance);
        setBalance(compoundedBalance.setScale(2, RoundingMode.HALF_UP));
        setUpdatedAt(LocalDateTime.now());
        lastInterestCalculation = LocalDateTime.now();
    }
    
    private void applyPenalty() {
        BigDecimal penalty = new BigDecimal("25.00");
        setBalance(getBalance().subtract(penalty));
    }
    
    private BigDecimal calculateAvailableBalance() {
        BigDecimal balance = getBalance();
        if (balance.compareTo(minimumBalance) < 0) {
            return BigDecimal.ZERO;
        }
        return balance.subtract(minimumBalance);
    }
    
    private void validateAccountIsActive() {
        if (getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException(
                "La cuenta de inversión no está activa. Estado actual: " + getStatus()
            );
        }
    }
    
    public BigDecimal getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
    
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
    
    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
    
    public InvestmentRiskLevel getRiskLevel() {
        return riskLevel;
    }
    
    public void setRiskLevel(InvestmentRiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }
    
    public LocalDateTime getLastInterestCalculation() {
        return lastInterestCalculation;
    }
    
    public void setLastInterestCalculation(LocalDateTime lastInterestCalculation) {
        this.lastInterestCalculation = lastInterestCalculation;
    }
    
    public boolean isCompoundInterest() {
        return compoundInterest;
    }
    
    public void setCompoundInterest(boolean compoundInterest) {
        this.compoundInterest = compoundInterest;
    }
}