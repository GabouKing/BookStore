package com.gk.bookstore.infra.paymentService;

import com.gk.bookstore.core.dto.PaymentTypeEnum;
import com.gk.bookstore.infra.paymentService.impl.MockPaymentService;
import com.gk.bookstore.infra.paymentService.impl.PixPayment;

public class PaymentServiceFactory {
    public static PaymentService getPaymentService(PaymentTypeEnum paymentType) {
        return switch (paymentType) {
            case PIX -> new PixPayment();
            case MOCK -> new MockPaymentService();
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }
}
