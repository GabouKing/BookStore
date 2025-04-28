package com.gk.bookstore.core.usecases.cart;

import com.gk.bookstore.core.dto.PaymentTypeEnum;

public interface PaymentUseCase {
    boolean payment(Long orderId, PaymentTypeEnum paymentType);
}
