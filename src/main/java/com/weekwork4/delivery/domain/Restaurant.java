package com.weekwork4.delivery.domain;


import com.weekwork4.delivery.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id // Id 값 PK로 쓰겠단 의미
    @GeneratedValue(strategy = GenerationType.AUTO)// 자동증가
    private Long id;

    @Column(nullable = false) // 컬럼값이 반드시 존재
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(RestaurantRequestDto requestDto) {
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }  // 얘가 왜들어가야하지? ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★



//    public Restaurant(String name, Long minOrderPrice, Long deliveryFee){
//        this.name = name;
//        this.minOrderPrice = minOrderPrice;
//        this.deliveryFee = deliveryFee;
//
//    } DTO로 넘긴건가?


}
