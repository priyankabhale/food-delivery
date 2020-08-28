package com.test.fooddelivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fooddelivery.dao.Customer;
import com.test.fooddelivery.dao.FoodMenu;
import com.test.fooddelivery.dao.OrderPojo;
import com.test.fooddelivery.dao.Orders;
import com.test.fooddelivery.repositories.CustomerRepository;
import com.test.fooddelivery.repositories.FoodMenuRepository;
import com.test.fooddelivery.repositories.OrdersRepository;

@RestController
public class OrderController {

  @Autowired
  CustomerRepository custRepo;

  @Autowired
  OrdersRepository orderRepo;

  @Autowired
  FoodMenuRepository foodRepo;

  @GetMapping("/order")
  public List<Orders> getOrders(@RequestParam(value = "email", required = true) String email) {
//    get customer info
    Customer cust = custRepo.findByEmail(email);
    if (cust != null) {
      List<Orders> orders = orderRepo.findByCustomer(cust.getId()).orElse(null);
      if (orders != null && !orders.isEmpty())
        return orders;
      else
        return null;
    } else {
      return null;
    }
  }

  @PostMapping("/order")
  public @ResponseBody Long fetchFood(@RequestBody OrderPojo pojo) {
    Orders orders = new Orders();

    Customer cust = custRepo.findByEmail(pojo.getEmail());
    if (cust == null) {
      Customer c = new Customer();
      c.setEmail(pojo.getEmail());
      c.setName(pojo.getEmail().substring(0, pojo.getEmail().indexOf("@")));
      custRepo.save(c);
      cust = c;
    }

    orders.setCustomer(cust);

    orders.setDestination(pojo.getDest());

    List<FoodMenu> foodmenuList = new ArrayList<>();
    for (Long id : pojo.getFoodIds()) {
      foodmenuList.add(foodRepo.findById(id).get());
    }
    orders.setFoodmenu(foodmenuList);

    orderRepo.save(orders);
    return orders.getId();
  }

  @PutMapping("/order/{orderId}")
  public @ResponseBody Orders fetchFood(@RequestBody Orders order, @PathVariable("orderId") long id) {
    Orders validOrder = orderRepo.findById(id).get();
    if (validOrder != null) {
      orderRepo.save(order);
    }
    return order;
  }

  @DeleteMapping("/order/{orderId}")
  public void fetchFood(@PathVariable("orderId") long id) {
    Orders validOrder = orderRepo.findById(id).get();
    if (validOrder != null) {
      orderRepo.delete(validOrder);
    }
  }

}
