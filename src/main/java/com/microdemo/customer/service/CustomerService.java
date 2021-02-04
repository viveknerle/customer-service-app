package com.microdemo.customer.service;

import com.microdemo.customer.entity.Customer;

import java.util.List;

public interface CustomerService {

  List<Customer> fetchAllCustomers();

  Customer fetchCustomerById(String id);

  Customer saveCustomerInfo(Customer account);

  void deleteCustomer(String id);
}