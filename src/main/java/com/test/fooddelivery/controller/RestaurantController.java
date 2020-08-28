package com.test.fooddelivery.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fooddelivery.dao.FoodMenu;
import com.test.fooddelivery.dao.Restaurant;
import com.test.fooddelivery.repositories.RestaurantRepository;
import com.test.fooddelivery.service.RestaurantService;

@RestController
public class RestaurantController {

  @Autowired
  RestaurantRepository restRepo;
  
  @Autowired
  RestaurantService restaurantService;

  // returns all restaurants and the food served by them
  @GetMapping("/restaurant")
  public @ResponseBody List<Restaurant> fetchFood() {
    List<Restaurant> restList = new ArrayList<>();
    restList = restRepo.findAll();
    for(Restaurant restaurant : restList) {
      restaurantService.priceAdjustingMatix(restaurant);
    }
    return restList;
  }

  // returns all restaurants and the food served by them
  @GetMapping("/restaurant/id/{restId}")
  public @ResponseBody Restaurant getSingleRestaurant(@PathVariable long restId) {
    Restaurant rest = restRepo.findById(restId).orElse(null);
    restaurantService.priceAdjustingMatix(rest);
    return rest;
  }

//returns all restaurants having ratings greater than the mentioned rating
  @GetMapping("/restaurant/rating/{rating}")
  public @ResponseBody List<Restaurant> getRestaurantBasedOnRatings(@PathVariable int rating) {
    List<Restaurant> restList = restRepo.findByRatingsGreaterThanEqual(rating);
    for(Restaurant restaurant : restList) {
      restaurantService.priceAdjustingMatix(restaurant);
    }
    return restList;
  }

//returns all restaurants having ratings greater than the mentioned rating
//  and foodmenu lesser than the mentioned price
  @GetMapping("/restaurant/rating/{rating}/price/{price}")
  public @ResponseBody List<Restaurant> getRestaurantBasedOnRatingsAndPrice(@PathVariable int rating,
      @PathVariable double price) {
    List<Restaurant> restlist = restRepo.findByRatingsGreaterThanEqual(rating);
    for (Restaurant rest : restlist) {
      restaurantService.priceAdjustingMatix(rest);
      Iterator<FoodMenu> itr = rest.getFoodmenu().iterator();
      while (itr.hasNext()) {
        FoodMenu foodMenu = (FoodMenu) itr.next();
        if (foodMenu.getPrice() > price)
          itr.remove();
      }
    }
    return restlist;
  }

}
