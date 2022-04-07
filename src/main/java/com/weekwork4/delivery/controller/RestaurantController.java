package com.weekwork4.delivery.controller;

import com.weekwork4.delivery.domain.Restaurant;
import com.weekwork4.delivery.dto.RestaurantRequestDto;
import com.weekwork4.delivery.repository.RestaurantRepository;
import com.weekwork4.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    //음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant (@RequestBody RestaurantRequestDto restaurantRequestDto) throws Exception {

        restaurantService.registerRestaurant(restaurantRequestDto);
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        return restaurantRepository.save(restaurant);
    }

    //음식점 전체 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {

        return restaurantRepository.findAll();
    }



}
