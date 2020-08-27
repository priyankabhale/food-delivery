package com.test.fooddelivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fooddelivery.dao.Restaurant;
import com.test.fooddelivery.repositories.RestaurantRepository;

@RestController
public class RestaurantController {
  
  @Autowired
  RestaurantRepository restRepo;

  //  returns all restaurants and the food served by them
  @GetMapping("/restaurant")
  public @ResponseBody List<Restaurant> fetchFood() {
    List<Restaurant> menu = new ArrayList<>();
    menu = restRepo.findAll();
    return menu;
  }
  
  //returns all restaurants and the food served by them
  @GetMapping("/restaurant/{restId}}")
  public @ResponseBody Restaurant getSingleRestaurant(@PathVariable("restId") long restId) {
    Restaurant rest = restRepo.findById(restId).orElse(null);
    return rest;
  }


}
