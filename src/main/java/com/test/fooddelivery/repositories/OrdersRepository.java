package com.test.fooddelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.fooddelivery.dao.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
  
//  @Query("select p from Paper p where p.student.id = :student.id order by p.student.dateSubmitted")
//  List<Paper> findByStudentOrderByDateSubmitted(@Param("student") Student student);
  
  @Query("select o from Orders o where o.customer.id=?1")
  List<Orders> findByCustomer(Long custid);

}
