package com.microdemo.customer.service.impl;

import com.microdemo.customer.entity.Customer;
import com.microdemo.customer.repository.CustomerRepository;
import com.microdemo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Customer> fetchAllCustomers() {
    return customerRepository.getAllCustomers();
  }

  @Override
  public Customer fetchCustomerById(String id) {
    return customerRepository.findById(id).get();
  }

  @Override
  public Customer saveCustomerInfo(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(String id) {
    customerRepository.deleteById(id);
  }

}