package com.test.fooddelivery.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  String name;

  String email;

//  @OneToMany(mappedBy = "customer")
//  private Set<Order> orders;

  public Customer() {
    // TODO Auto-generated constructor stub
  }

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

//  public Set<Order> getOrders() {
//    return orders;
//  }
//
//  public void setOrders(Set<Order> orders) {
//    this.orders = orders;
//  }

}
