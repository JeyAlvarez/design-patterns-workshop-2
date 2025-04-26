package com.example.patterns_banking.factory;

import java.util.List;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;

public interface CustomerFactory {

    List<Account> getAccounts(Customer customer);
}