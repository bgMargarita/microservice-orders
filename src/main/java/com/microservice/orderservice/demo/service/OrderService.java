package com.microservice.orderservice.demo.service;

import com.microservice.orderservice.demo.DTO.ItemAdditionParametersDto;
import com.microservice.orderservice.demo.DTO.OrderDto;
import com.microservice.orderservice.demo.entity.Order;
import com.microservice.orderservice.demo.entity.OrderItem;
import com.microservice.orderservice.demo.entity.OrderStatus;
import com.microservice.orderservice.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto changeOrderStatus(String id, String status) {
        final Optional<Order> orderOptional = orderRepository.findById(id);
        Order orderFromDb;
        if(orderOptional.isPresent()) {
            orderFromDb = orderOptional.get();
            final OrderStatus newOrderStatus = OrderStatus.valueOf(status);
            orderFromDb.setOrderStatus(newOrderStatus);
            orderRepository.save(orderFromDb);
            return new OrderDto(orderFromDb.getId(), newOrderStatus);
        } else {
            return null;
        }
    }

    public List<OrderDto> getAllOrders() {
        List<Order> ordersFromDbList = orderRepository.findAll();
        List<OrderDto> ordersDtoList = new ArrayList<>();
        for(Order orderFromDb: ordersFromDbList) {
            ordersDtoList.add(new OrderDto(orderFromDb));
        }
        return ordersDtoList;
    }

    public OrderDto getOrderById(String id) {
        final Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order orderFromDb = orderOptional.get();
            return new OrderDto(orderFromDb);
        } else {
            return null;
        }
    }

    public OrderDto addItemToOrder(String id, ItemAdditionParametersDto itemAdditionParametersDto) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order orderFromDb = orderOptional.get();
            orderFromDb.getOrderItemList().add(new OrderItem(itemAdditionParametersDto));
            orderRepository.save(orderFromDb);
            return new OrderDto(orderFromDb);
        } else {
            Order order = new Order(itemAdditionParametersDto);
            orderRepository.save(order);
            return new OrderDto(order);
        }
    }
}
