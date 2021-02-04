package com.microdemo.customer.repository;

import com.microdemo.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

  @Query("FROM Customer c")
  List<Customer> getAllCustomers();

}