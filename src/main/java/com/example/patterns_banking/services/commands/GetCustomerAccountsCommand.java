package com.example.patterns_banking.services.commands;

import java.util.List;
import java.util.Optional;

import com.example.patterns_banking.factory.CustomerFactory;
import com.example.patterns_banking.factory.CustomerFactoryProvider;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.ICustomerRepository;


public class GetCustomerAccountsCommand implements ICommand<Customer> {
    private final ICustomerRepository customerRepository;
    private Long customerId;
    private CustomerFactoryProvider customerFactoryProvider;

    public GetCustomerAccountsCommand(ICustomerRepository customerRepository, CustomerFactoryProvider customerFactoryProvider, long id) {
        this.customerRepository = customerRepository;
        this.customerId = id;
        this.customerFactoryProvider = customerFactoryProvider;
    }

    @Override
    public List<Account> executeAll() {
         Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        Customer customer = customerOptional.get();
        CustomerFactory accountFactory = customerFactoryProvider.getFactory();
        List<Account> accounts = accountFactory.getAccounts(customer);

        return accounts;
    }

    @Override
    public Account execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
