package com.test.fooddelivery.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

public class OrderPojo {
  private String dest;
  private String email;
  private List<Long> foodIds;
  
  public OrderPojo() {
  }

  public String getDest() {
    return dest;
  }

  public void setDest(String dest) {
    this.dest = dest;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Long> getFoodIds() {
    return foodIds;
  }

  public void setFoodIds(List<Long> foodIds) {
    this.foodIds = foodIds;
  }
  
}
