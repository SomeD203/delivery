package com.weekwork4.delivery.controller;

import com.weekwork4.delivery.dto.OrderRequestDto;
import com.weekwork4.delivery.dto.OrderResponseDto;
import com.weekwork4.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문 요청
    @PostMapping("/order/request")
    public OrderResponseDto orderFood(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.orderFood(orderRequestDto);
    }

    // 주문 조회
    @GetMapping("/orders")
    public List<OrderResponseDto> getOrderList() {

        return orderService.getOrderList();

    }
}
