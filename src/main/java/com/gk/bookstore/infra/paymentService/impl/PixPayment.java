package com.gk.bookstore.infra.paymentService.impl;

import com.gk.bookstore.core.model.OrderBuy;
import com.gk.bookstore.infra.paymentService.PaymentService;

import java.util.Random;

public class PixPayment  implements PaymentService {
    @Override
    public boolean payment(OrderBuy orderBuy) {
        // retorna true em 80% dos casos
        Random number = new Random();
        return number.nextDouble() < 0.8;
    }
}
