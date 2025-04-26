package com.example.patterns_banking.controllers;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.services.CustomerService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
    return ResponseEntity.ok(customerService.create(customerDTO));
  }
  
  @GetMapping("/accounts")
  public ResponseEntity<List<Account>> getCustomerAccounts(@RequestParam Long customerId) {
    return ResponseEntity.ok(customerService.getCustomerAccounts(customerId));
  }

}
