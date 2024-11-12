package com.example.Order.Repo;

import com.example.Order.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo  extends JpaRepository<Order,Long> {
}
