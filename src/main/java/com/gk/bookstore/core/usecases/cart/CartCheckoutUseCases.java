package com.gk.bookstore.core.usecases.cart;

import com.gk.bookstore.core.dto.OrderDTO;
import com.gk.bookstore.core.model.OrderBuy;

public interface CartCheckoutUseCases {
    OrderBuy checkouOrder(OrderDTO order);
}
