package com.test.fooddelivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fooddelivery.dao.FoodMenu;
import com.test.fooddelivery.repositories.FoodMenuRepository;

@RestController
public class FoodController {

  @Autowired
  FoodMenuRepository foodRepo;

  @GetMapping("/foodmenu")
  public @ResponseBody List<FoodMenu> fetchFood() {
    List<FoodMenu> menu = new ArrayList<>();
    menu = foodRepo.findAll();
    return menu;
  }
  
}
