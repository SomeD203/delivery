package com.weekwork4.delivery.dto;

import com.weekwork4.delivery.domain.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {
    private String restaurantName;
    private List<FoodOrderResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;



    public OrderResponseDto(Order order, List<FoodOrderResponseDto> foodOrderResponseDtoList) {
        this.restaurantName = order.getRestaurantName();
        this.foods= foodOrderResponseDtoList;
        this.deliveryFee = order.getDeliveryFee();
        this.totalPrice = order.getTotalPrice();
    }
}
