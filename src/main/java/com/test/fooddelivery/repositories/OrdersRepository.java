package com.test.fooddelivery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.fooddelivery.dao.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
  
  @Query("select o from Orders o where o.customer.id=?1")
  Optional<List<Orders>> findByCustomer(Long custid);

}
