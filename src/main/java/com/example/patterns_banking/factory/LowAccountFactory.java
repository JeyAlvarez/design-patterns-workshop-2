package com.example.patterns_banking.factory;

import org.springframework.stereotype.Component;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.models.LowAmountAccount;

@Component
public class LowAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(Customer customer, String accountNumber, Double balance) {
        LowAmountAccount account = new LowAmountAccount();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setCustomer(customer);
        return account;
    }

}
