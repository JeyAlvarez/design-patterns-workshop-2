package com.example.patterns_banking.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class LowAmountAccount extends Account {
  private static final double DEPOSIT_FEE_RATE = 0.01; // 1% fee for deposits
  private static final double FREE_TRANSACTION_THRESHOLD = 100.0; // Si el monto supera este valor, se le debe descontar: DEPOSIT_FEE_RATE, sino, el deposito es gratis

  @Override
  public Double calculateDepositFee(Double amount) {
    if (amount > FREE_TRANSACTION_THRESHOLD) {
      return amount * DEPOSIT_FEE_RATE;
    } else {
      return 0.0;
    }
  }
}
