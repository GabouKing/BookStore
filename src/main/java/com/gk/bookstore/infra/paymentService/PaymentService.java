package com.gk.bookstore.infra.paymentService;

import com.gk.bookstore.core.model.OrderBuy;

public interface PaymentService {
    boolean payment(OrderBuy orderBuy);
}
