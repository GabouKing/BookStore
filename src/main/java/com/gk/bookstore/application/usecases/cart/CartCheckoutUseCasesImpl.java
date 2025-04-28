package com.gk.bookstore.application.usecases.cart;

import com.gk.bookstore.adapters.paymentGateway.CartCheckoutGateway;
import com.gk.bookstore.core.dto.OrderDTO;
import com.gk.bookstore.core.model.OrderBuy;
import com.gk.bookstore.core.usecases.cart.CartCheckoutUseCases;
import org.springframework.stereotype.Service;

@Service
public class CartCheckoutUseCasesImpl implements CartCheckoutUseCases {
    private final CartCheckoutGateway cartCheckoutGateway;

    public CartCheckoutUseCasesImpl(CartCheckoutGateway cartCheckoutGateway) {
        this.cartCheckoutGateway = cartCheckoutGateway;
    }

    @Override
    public OrderBuy checkouOrder(OrderDTO order) {
        return cartCheckoutGateway.checkouOrder(order);
    }
}
