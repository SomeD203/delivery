package com.weekwork4.delivery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String restaurantName;

    private int totalPrice;

    private int deliveryFee;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FOOD_ORDER_ID")
    private List<FoodOrder> foodOrderList;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public Order(String restaurantName, List<FoodOrder> foodOrderList, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foodOrderList = foodOrderList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;

    }
}
