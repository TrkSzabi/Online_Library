package com.sda.traianszabi.online_library.service;

import ch.qos.logback.classic.jmx.MBeanUtil;
import com.sda.traianszabi.online_library.model.Order;
import com.sda.traianszabi.online_library.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    @Transactional
    public void createOrder (Order order) {
       orderRepository.save(order);

    }

    public Iterable<Order> getOrders () {
        return orderRepository.findAll();
    }






}
