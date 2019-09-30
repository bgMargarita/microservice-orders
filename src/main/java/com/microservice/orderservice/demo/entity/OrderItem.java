package com.microservice.orderservice.demo.entity;

import com.microservice.orderservice.demo.DTO.ItemAdditionParametersDto;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class OrderItem {
    private String id;
    private Integer amount;
    private String username;

    public OrderItem(ItemAdditionParametersDto itemAdditionParametersDto) {
        this.id = itemAdditionParametersDto.getId();
        this.amount = itemAdditionParametersDto.getAmount();
        this.username = itemAdditionParametersDto.getUsername();
    }
}
