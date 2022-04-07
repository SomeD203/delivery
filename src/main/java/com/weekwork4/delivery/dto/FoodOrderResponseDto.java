package com.weekwork4.delivery.dto;


import com.weekwork4.delivery.domain.FoodOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodOrderResponseDto {
    private String name;
    private int quantity;
    private int price;

    public FoodOrderResponseDto(FoodOrder entity){
        this.name = entity.getName();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();

    }

}
