package com.microservice.orderservice.demo.DTO;

import lombok.Data;

@Data
public class ItemAdditionParametersDto {
    private final String id;
    private final String username;
    private final Integer amount;
}
