package com.sda.traianszabi.online_library.repository;

import com.sda.traianszabi.online_library.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
