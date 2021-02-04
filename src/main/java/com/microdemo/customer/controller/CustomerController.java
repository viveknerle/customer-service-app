package com.microdemo.customer.controller;

import com.microdemo.customer.entity.Customer;
import com.microdemo.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "/")
  public ResponseEntity<Collection<Customer>> getAllCustomers() {
    log.info("Fetch all customer information.");
    List<Customer> listCustomers = customerService.fetchAllCustomers();
    return new ResponseEntity<>(listCustomers, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("id") String customerId) {
    log.info("Fetch customer information for id: {}", customerId);
    Customer customer = customerService.fetchCustomerById(customerId);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<Customer> updateCustomer(@RequestBody final Customer customer) {
    log.info("Update customer information for id: {}", customer.getId());
    Customer savedCustomer = customerService.saveCustomerInfo(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") String customerId) {
    log.info("Delete customer information for id: {}", customerId);
    customerService.deleteCustomer(customerId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Customer> createCustomer(@RequestBody final Customer customer) {
    log.info("Create new customer");
    Customer savedCustomer = customerService.saveCustomerInfo(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
  }

  @GetMapping(value = "/accounts/{id}")
  public ResponseEntity<Collection<Account>> getCustomerAllAccounts(@PathVariable(name = "id") String customerId) {
    log.info("Fetch all customer information.");
    List<Account> listCustomers = customerService.getCustomerAllAccounts(customerId);
    return new ResponseEntity<>(listCustomers, HttpStatus.OK);
  }
}