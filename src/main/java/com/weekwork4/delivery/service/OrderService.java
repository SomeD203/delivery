package com.weekwork4.delivery.service;

import com.weekwork4.delivery.domain.FoodOrder;
import com.weekwork4.delivery.domain.Order;
import com.weekwork4.delivery.domain.Restaurant;
import com.weekwork4.delivery.dto.*;
import com.weekwork4.delivery.repository.OrderRepository;
import com.weekwork4.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodService foodService;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, FoodService foodService, RestaurantRepository restaurantRepository){
        this.orderRepository = orderRepository;
        this.foodService = foodService;
        this.restaurantRepository = restaurantRepository;

    }

    @Transactional
    public OrderResponseDto orderFood(OrderRequestDto orderRequestDto){
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("음식점 ID가 없어욤"));

        List<FoodOrder> foodOrderList = new ArrayList<>();
        List<FoodOrderResponseDto> foodOrderResponseDtoList = new ArrayList<>();

        List<FoodOrderRequestDto> foodOrderRequestDtoList = orderRequestDto.getFoods();
        for(FoodOrderRequestDto foodOrderRequestDto : foodOrderRequestDtoList){

            if(foodOrderRequestDto.getQuantity()<0 || foodOrderRequestDto.getQuantity()>100){
                throw new IllegalArgumentException("주문 가능한 음식 수량을 초과하였습니다");
            }

            List<FoodResponseDto> foodList = foodService.getMenus(orderRequestDto.getRestaurantId());
            for(FoodResponseDto food : foodList) {

                if(!food.getId().equals(foodOrderRequestDto.getId())){
                    continue;
                }

                String foodname = food.getName();
                int quantity = foodOrderRequestDto.getQuantity();
                int price = food.getPrice() * quantity;

                FoodOrder foodOrder = new FoodOrder(
                        foodname,
                        foodOrderRequestDto.getQuantity(),
                        food.getPrice());

                foodOrderList.add(foodOrder);

                foodOrderResponseDtoList.add(new FoodOrderResponseDto(foodOrder));
            }
        }

        //주문음식 총 가격
        int sumFoodsPrice = 0;
        for(FoodOrderResponseDto foodInfo : foodOrderResponseDtoList ) {
            sumFoodsPrice += foodInfo.getPrice();
        }

        System.out.println(sumFoodsPrice);

        if(sumFoodsPrice< restaurant.getMinOrderPrice()) {
            throw new IllegalArgumentException("주문금액이 최소주문금액보다 작습니다.");
        }

        Order order = new Order(
                restaurant.getName(),
                foodOrderList,
                restaurant.getDeliveryFee(),
                sumFoodsPrice + restaurant.getDeliveryFee());

        orderRepository.save(order);

        return new OrderResponseDto(order, foodOrderResponseDtoList);
    }

    //    //주문 조회
    @Transactional
    public List<OrderResponseDto> getOrderList() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        for(Order order : orderList) {
            List<FoodOrderResponseDto> foodOrderResponseDtoList = new ArrayList<>();
            for(FoodOrder foodOrder: order.getFoodOrderList()) {
                FoodOrderResponseDto foodOrderResponseDto = new FoodOrderResponseDto(foodOrder);
                foodOrderResponseDtoList.add(foodOrderResponseDto);
            }
            OrderResponseDto orderResponseDto = new OrderResponseDto(order, foodOrderResponseDtoList);
            orderResponseDtoList.add(orderResponseDto);
        }

        return orderResponseDtoList;
    }
}