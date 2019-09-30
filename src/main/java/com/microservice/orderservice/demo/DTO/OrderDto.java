package com.microservice.orderservice.demo.DTO;

import com.microservice.orderservice.demo.entity.Order;
import com.microservice.orderservice.demo.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private final String id;
    private final OrderStatus orderStatus;

    public OrderDto(Order orderFromDb) {
        this.id = orderFromDb.getId();
        this.orderStatus = orderFromDb.getOrderStatus();
    }
}
