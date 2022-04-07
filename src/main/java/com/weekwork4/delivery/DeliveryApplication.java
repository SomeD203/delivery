package com.weekwork4.delivery;

import com.weekwork4.delivery.domain.Restaurant;
import com.weekwork4.delivery.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);

    }

//    @Bean
//    public CommandLineRunner demo(RestaurantRepository repository){
//        return (args) -> {
//
//
//
//        };
//    }  //원래 없는코드임

}
