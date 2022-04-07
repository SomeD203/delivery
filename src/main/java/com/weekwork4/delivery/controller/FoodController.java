package com.weekwork4.delivery.controller;


import com.weekwork4.delivery.domain.Food;
import com.weekwork4.delivery.dto.FoodRequestDto;
import com.weekwork4.delivery.dto.FoodResponseDto;
import com.weekwork4.delivery.repository.FoodRepository;
import com.weekwork4.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // 음식리스트 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> foodRequestDtoList) {
        foodService.addFoods(restaurantId, foodRequestDtoList);
    }

    //메뉴판 조회
    @GetMapping("restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getMenus(@PathVariable Long restaurantId) {
        return foodService.getMenus(restaurantId);
    }
}
