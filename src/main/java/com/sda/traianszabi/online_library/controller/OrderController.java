package com.sda.traianszabi.online_library.controller;

import com.sda.traianszabi.online_library.model.Order;
import com.sda.traianszabi.online_library.repository.OrderRepository;
import com.sda.traianszabi.online_library.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;


    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;

    }

    @PostMapping("/order/create")
    public String createOrder(@Valid @RequestBody Order order) {
        orderService.createOrder(order);
        return "Order has been succesfull saved";
    }

    @GetMapping("/orders")
    public Iterable<Order> getAllOrders() {
        return orderService.getOrders();
    }



//    @PatchMapping("/orders/{id}")
//    public ResponseEntity<?> saveOrder(@Valid @RequestBody Order order,
//                                      @PathVariable("id") String id) {
//       orderRepository.save(order);
//        return ResponseEntity.ok("resource saved");
   }

    }


