package com.weekwork4.delivery.service;

import com.weekwork4.delivery.domain.Restaurant;
import com.weekwork4.delivery.dto.RestaurantRequestDto;
import com.weekwork4.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
//@RequiredArgsConstructor // 16-18 자동 생성자 생성 어노테이션
public class RestaurantService {

    private final RestaurantRepository restaurantRepository ;

//    public RestaurantService(RestaurantRepository restaurantRepository){
//        this.restaurantRepository = restaurantRepository;
//    }

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public void registerRestaurant(RestaurantRequestDto restaurantRequestDto) throws Exception {

        String name = restaurantRequestDto.getName();
        int minOrderPrice = restaurantRequestDto.getMinOrderPrice();
        int deliveryFee = restaurantRequestDto.getDeliveryFee();

        if(minOrderPrice<1000 || minOrderPrice>100000) {
            throw new IllegalArgumentException("최소 주문 가격은 1000~100,000원 입니다.");
        }

        if(minOrderPrice%100!=0) {
            throw new IllegalArgumentException("최소 주문 100원 단위로 해주시기 바랍니다.");
        }

        if(deliveryFee<0 || deliveryFee>10000) {
            throw new IllegalArgumentException("기본 배달비는 0~10000원으로 500원 단위입니다.");
        }
        if(deliveryFee%500!=0) {
            throw new IllegalArgumentException("기본 배달비는 0~10000원으로 500원 단위입니다.");
        }


    }

}
