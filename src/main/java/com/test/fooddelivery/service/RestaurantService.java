package com.test.fooddelivery.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.fooddelivery.dao.FoodMenu;
import com.test.fooddelivery.dao.Restaurant;
import com.test.fooddelivery.util.Constants;

@Service
public class RestaurantService {
  
  public Restaurant priceAdjustingMatix(Restaurant restaurant) {

    LocalTime currentTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).toLocalTime();
    if (currentTime.isAfter(Constants.MORNING_OPEN) && currentTime.isBefore(Constants.MORNING_CLOSE)) {
      revisedFoodPrice(restaurant.getFoodmenu(), Constants.morningInflation);
    } else if (currentTime.isAfter(Constants.AFTERNOON_OPEN) && currentTime.isBefore(Constants.AFTERNOON_CLOSE)) {
      revisedFoodPrice(restaurant.getFoodmenu(), Constants.afternoonInflation);
    } else if (currentTime.isAfter(Constants.EVENING_OPEN) && currentTime.isBefore(Constants.EVENING_CLOSE)) {
      revisedFoodPrice(restaurant.getFoodmenu(), Constants.eveningInflation);
    }
    return restaurant;
  }

  public void revisedFoodPrice(List<FoodMenu> fooMenuList, double inflation) {
    for (FoodMenu menu : fooMenuList) {
      menu.setPrice((menu.getPrice()) + (menu.getPrice() * inflation));
    }
  }

}
