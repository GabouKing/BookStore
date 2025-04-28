package com.gk.bookstore.adapters.paymentGateway;

import com.gk.bookstore.core.dto.OrderDTO;
import com.gk.bookstore.core.model.OrderBuy;

public interface CartCheckoutGateway {
    OrderBuy checkouOrder(OrderDTO order);
}
