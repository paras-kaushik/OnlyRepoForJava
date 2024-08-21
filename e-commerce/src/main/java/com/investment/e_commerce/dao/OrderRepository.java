package com.investment.e_commerce.dao;

import com.investment.e_commerce.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<UserOrder,Long> {
    // Custom finder method to find an order by its order number
    Optional<UserOrder> findByOrderNumber(String orderNumber);
}
