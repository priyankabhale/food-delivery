package com.test.fooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.fooddelivery.dao.Customer;
import com.test.fooddelivery.repositories.CustomerRepository;

@RestController("/customer")
public class CustomerController {
  @Autowired
  CustomerRepository custrepo;

  @GetMapping
  public String findAll() {
    return custrepo.findAll().toString();
  }
  
  @PostMapping
  public void addCustomer(Customer cust) {
    custrepo.save(cust);
  }
}
