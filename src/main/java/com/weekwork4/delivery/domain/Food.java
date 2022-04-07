package com.weekwork4.delivery.domain;

import com.weekwork4.delivery.dto.FoodRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(targetEntity = Restaurant.class)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    //manyToOne에서는 @JoinColumn 선언하지 않아도 조인테이블 생성되지 않음.
    private Restaurant restaurant;

//    @OneToMany(mappedBy = "food")
//    private List<OrderEntity> orderEntities = new ArrayList<>();

    @Builder
    public Food(Restaurant restaurant, FoodRequestDto foodRequestDto) {
        this.restaurant = restaurant;
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
    }

}

