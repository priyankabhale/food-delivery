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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurant")
public class Restaurant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private int ratings;

  private String place;
  
//  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "restautant_food_menu", 
    joinColumns = @JoinColumn(name = "rest_id"), 
    inverseJoinColumns = @JoinColumn(name = "food_id"))
  List<FoodMenu> foodmenu= new ArrayList<>();


  public Restaurant() {
  }

  public Restaurant(String name, int ratings, String place) {
    this.name = name;
    this.ratings = ratings;
    this.place = place;
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

  public int getRatings() {
    return ratings;
  }

  public void setRatings(int ratings) {
    this.ratings = ratings;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public List<FoodMenu> getFoodmenu() {
    return foodmenu;
  }

  public void setFoodmenu(List<FoodMenu> foodmenu) {
    this.foodmenu = foodmenu;
  }

}
