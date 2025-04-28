package com.gk.bookstore.infra.repositories;

import com.gk.bookstore.core.model.OrderBuy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderBuy, Long> {
}
