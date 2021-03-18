package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
