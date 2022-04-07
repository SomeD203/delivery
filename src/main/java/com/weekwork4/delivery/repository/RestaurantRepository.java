package com.weekwork4.delivery.repository;


import com.weekwork4.delivery.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {




}
