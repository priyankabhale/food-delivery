package com.test.fooddelivery;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.fooddelivery.dao.Customer;
import com.test.fooddelivery.dao.FoodMenu;
import com.test.fooddelivery.dao.Restaurant;
import com.test.fooddelivery.repositories.CustomerRepository;
import com.test.fooddelivery.repositories.FoodMenuRepository;
import com.test.fooddelivery.repositories.RestaurantRepository;

@SpringBootApplication
public class FoodDeliveryApplication implements CommandLineRunner {

  @Autowired
  FoodMenuRepository foodMenuRepository;
  
  @Autowired
  RestaurantRepository restaurantRepository;
  
  @Autowired
  CustomerRepository customerRepository;

  public static void main(String[] args) {
    SpringApplication.run(FoodDeliveryApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    
//    save food menu
    FoodMenu menu1 = new FoodMenu("Lasagna", 50.0d);
    FoodMenu menu2 = new FoodMenu("Pizza",100.0d);
    FoodMenu menu3 = new FoodMenu("Burger", 30.0d);
    FoodMenu menu4 = new FoodMenu("Soup",80.0d);
    
//    save restaurants
    Restaurant rest1 = new Restaurant("Mariot", 9, "Mumbai");
    Restaurant rest2 = new Restaurant("Ibis", 8, "Kolkata");
    
    menu1.getRestaurants().add(rest1);
    rest1.getFoodmenu().add(menu1);
    
    menu2.getRestaurants().add(rest1);
    rest1.getFoodmenu().add(menu2);
    
    menu3.getRestaurants().add(rest1);
    rest1.getFoodmenu().add(menu3);
    
    menu4.getRestaurants().add(rest1);
    rest1.getFoodmenu().add(menu4);
    
    menu2.getRestaurants().add(rest2);
    rest2.getFoodmenu().add(menu2);
    
    menu4.getRestaurants().add(rest2);
    rest2.getFoodmenu().add(menu4);
    
    menu1 = foodMenuRepository.save(menu1);
    menu2 = foodMenuRepository.save(menu2);
    menu3 = foodMenuRepository.save(menu3);
    menu4 = foodMenuRepository.save(menu4);
    rest1 = restaurantRepository.save(rest1);
    rest2 = restaurantRepository.save(rest2);
    
//    foodMenuRepository.save(menu1);
//    restaurantRepository.save(rest1);
//    do mapping
//    Set<FoodMenu> menuSet = new HashSet<>();
//    menuSet.add(menu1);
//    menuSet.add(menu2);
//    rest1.setFoodmenu(menuSet);
//    restaurantRepository.save(rest1);
    
  }

}
