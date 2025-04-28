package com.gk.bookstore.infra.paymentService;

import com.gk.bookstore.core.dto.PaymentTypeEnum;
import com.gk.bookstore.infra.paymentService.impl.MeliPayment;
import com.gk.bookstore.infra.paymentService.impl.MockPaymentService;

public class PaymentServiceFactory {
    public static PaymentService getPaymentService(PaymentTypeEnum paymentType) {
        return switch (paymentType) {
            case MELI -> new MeliPayment();
            case MOCK -> new MockPaymentService();
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }
}
