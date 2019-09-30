package com.microservice.orderservice.demo.controller;

import com.microservice.orderservice.demo.DTO.ItemAdditionParametersDto;
import com.microservice.orderservice.demo.DTO.OrderDto;
import com.microservice.orderservice.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<OrderDto> changeOrderStatus(@PathVariable String id, @PathVariable String status) {
        OrderDto orderDto = orderService.changeOrderStatus(id, status);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String id) {
        OrderDto orderDto = orderService.getOrderById(id);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("order/{id}")
    public ResponseEntity<OrderDto> addItemToOrder(@RequestBody ItemAdditionParametersDto itemAdditionParametersDto, @PathVariable String id) {
        OrderDto orderDto = orderService.addItemToOrder(id, itemAdditionParametersDto);
        if(orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
