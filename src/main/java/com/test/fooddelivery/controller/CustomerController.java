package com.test.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fooddelivery.dao.Customer;
import com.test.fooddelivery.repositories.CustomerRepository;

@RestController
public class CustomerController {

  @Autowired
  CustomerRepository custrepo;

  @GetMapping("/customer")
  public @ResponseBody List<Customer> findAll() {
    return custrepo.findAll();
  }

  @PostMapping("/customer")
  public @ResponseBody Long addCustomer(@RequestBody Customer cust) {
    Customer newcust = custrepo.save(cust);
    return newcust.getId();
  }

}
