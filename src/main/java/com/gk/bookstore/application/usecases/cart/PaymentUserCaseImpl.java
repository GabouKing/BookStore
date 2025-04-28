package com.gk.bookstore.application.usecases.cart;

import com.gk.bookstore.adapters.paymentGateway.PaymentGateway;
import com.gk.bookstore.core.dto.PaymentTypeEnum;
import com.gk.bookstore.core.usecases.cart.PaymentUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaymentUserCaseImpl implements PaymentUseCase {
    private final PaymentGateway paymentGateway;

    public PaymentUserCaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public boolean payment(Long orderId, PaymentTypeEnum paymentType) {
        return paymentGateway.payment(orderId, paymentType);
    }
}
