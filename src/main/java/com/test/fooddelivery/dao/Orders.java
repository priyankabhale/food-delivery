package com.test.fooddelivery.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String destination;

  @ManyToOne
  @JoinColumn(name = "cust_id")
  private Customer customer;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "orders_food_menu", joinColumns = @JoinColumn(name = "order_id"), 
  inverseJoinColumns = @JoinColumn(name = "food_id"))
  List<FoodMenu> foodmenu = new ArrayList<>();

  public Orders() {
  }

  public Orders(String destination) {
    this.destination = destination;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<FoodMenu> getFoodmenu() {
    return foodmenu;
  }

  public void setFoodmenu(List<FoodMenu> foodmenu) {
    this.foodmenu = foodmenu;
  }
  

}
