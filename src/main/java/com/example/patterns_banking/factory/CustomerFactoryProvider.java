package com.example.patterns_banking.factory;

import org.springframework.stereotype.Component;

@Component
public class CustomerFactoryProvider {
    private final CustomerFactory customerFactory;

    public CustomerFactoryProvider(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    public CustomerFactory getFactory() {
        return customerFactory;
    }

}
