package com.weekwork4.delivery.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class FoodRequestDto {
    private String name;
    private int price;

    @Builder
    public FoodRequestDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public FoodRequestDto toEntity(){
        return FoodRequestDto.builder()
                .name(name)
                .price(price)
                .build();
    }
}