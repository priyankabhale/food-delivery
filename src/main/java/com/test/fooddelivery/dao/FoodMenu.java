package com.test.fooddelivery.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "food_menu")
public class FoodMenu {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private double price;
  
  @JsonIgnore
  @ManyToMany(mappedBy = "foodmenu",fetch = FetchType.LAZY)
  private List <Restaurant> restaurants= new ArrayList<>();
  
  @JsonIgnore
  @ManyToMany(mappedBy = "foodmenu",fetch = FetchType.LAZY)
  private List<Orders> orders= new ArrayList<>();

  public FoodMenu() {
  }

  public FoodMenu(String name, double price) {
    super();
    this.name = name;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<Restaurant> getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(List<Restaurant> restaurants) {
    this.restaurants = restaurants;
  }

  public List<Orders> getOrders() {
    return orders;
  }

  public void setOrders(List<Orders> orders) {
    this.orders = orders;
  }
  

}
