package com.weekwork4.delivery.repository;


import com.weekwork4.delivery.domain.Food;
import com.weekwork4.delivery.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByNameAndRestaurant_Id(String name, Long restaurantId);

    List<Food> findAllByRestaurantId(Long restaurantId);
}
