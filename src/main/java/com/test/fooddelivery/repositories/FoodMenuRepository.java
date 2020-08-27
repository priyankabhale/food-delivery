package com.test.fooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.fooddelivery.dao.FoodMenu;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long>{

}
