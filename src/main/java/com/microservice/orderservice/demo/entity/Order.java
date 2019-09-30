package com.microservice.orderservice.demo.entity;

import com.microservice.orderservice.demo.DTO.ItemAdditionParametersDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String clientId;
    private Double totalCost = 0.0;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItemList;

    public Order(ItemAdditionParametersDto itemAdditionParametersDto) {
        this.getOrderItemList().add(new OrderItem(itemAdditionParametersDto));
    }
}
