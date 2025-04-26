package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.AccountDTO;
import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.factory.AccountFactoryProvider;
import com.example.patterns_banking.factory.CustomerFactoryProvider;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.CustomerRepository;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.commands.DepositCommand;
import com.example.patterns_banking.services.commands.GetCustomerAccountsCommand;
import com.example.patterns_banking.services.commands.ICommand;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerFactoryProvider customerFactoryProvider;
  private final ICustomerRepository customerRepository;

  public CustomerService(ICustomerRepository customerRepository, CustomerFactoryProvider customerFactoryProvider) {
    this.customerRepository = customerRepository;
    this.customerFactoryProvider = customerFactoryProvider;
  }

  public Customer create(CustomerDTO customerDTO) {
    Customer customer = Customer
      .builder()
      .name(customerDTO.getName())
      .email(customerDTO.getEmail())
      .build();

    return customerRepository.save(customer);
  }

  public List<Account> getCustomerAccounts(Long customerId) {
    ICommand<Customer> command = new GetCustomerAccountsCommand(customerRepository, customerFactoryProvider, customerId);
    return command.executeAll();
  }

}
