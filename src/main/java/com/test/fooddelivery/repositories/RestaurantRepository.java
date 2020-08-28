package com.test.fooddelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.fooddelivery.dao.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
  List<Restaurant> findByRatingsGreaterThanEqual(int rating);
}
