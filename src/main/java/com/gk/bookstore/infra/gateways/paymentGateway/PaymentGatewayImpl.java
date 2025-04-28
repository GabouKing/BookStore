package com.gk.bookstore.infra.gateways.paymentGateway;

import com.gk.bookstore.adapters.paymentGateway.PaymentGateway;
import com.gk.bookstore.core.dto.PaymentTypeEnum;
import com.gk.bookstore.core.dto.StatusEnum;
import com.gk.bookstore.core.model.OrderBuy;
import com.gk.bookstore.infra.paymentService.PaymentService;
import com.gk.bookstore.infra.paymentService.PaymentServiceFactory;
import com.gk.bookstore.infra.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayImpl implements PaymentGateway {
    private final OrderRepository orderRepository;

    public PaymentGatewayImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean payment(Long orderId, PaymentTypeEnum paymentType) {
        if (orderId == null || orderId <= 0) {
            throw new IllegalArgumentException("Invalid order id");
        }
        OrderBuy orderBuy = orderRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Order not found id: " + orderId));
        PaymentService paymentService = PaymentServiceFactory.getPaymentService(paymentType);
        boolean result = paymentService.payment(orderBuy);
        if (result) {
            orderBuy.setStatusEnum(StatusEnum.DONE);
        }else{
            orderBuy.setStatusEnum(StatusEnum.FAILED);
        }
        orderRepository.save(orderBuy);
        return result;
    }
}
