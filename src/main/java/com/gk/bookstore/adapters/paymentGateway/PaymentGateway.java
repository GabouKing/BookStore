package com.gk.bookstore.adapters.paymentGateway;

import com.gk.bookstore.core.dto.PaymentTypeEnum;

public interface PaymentGateway {
    boolean payment(Long orderId, PaymentTypeEnum paymentType);
}
