package com.test.fooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.fooddelivery.dao.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
  
  Customer findByEmail(String email);

}
