package com.gk.bookstore.controller;

import com.gk.bookstore.core.dto.OrderDTO;
import com.gk.bookstore.core.dto.PaymentTypeEnum;
import com.gk.bookstore.core.model.OrderBuy;
import com.gk.bookstore.core.usecases.cart.CartCheckoutUseCases;
import com.gk.bookstore.core.usecases.cart.PaymentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartCheckoutUseCases cartCheckoutUseCases;
    private final PaymentUseCase paymentUseCase;

    public CartController(CartCheckoutUseCases cartCheckoutUseCases, PaymentUseCase paymentUseCase) {
        this.cartCheckoutUseCases = cartCheckoutUseCases;
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping("/checkout")
    public ResponseEntity<OrderBuy> checkout(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<OrderBuy>(cartCheckoutUseCases.checkouOrder(orderDTO), HttpStatus.OK);
    }

    @PostMapping("/payment/{orderId}")
    public ResponseEntity<?> payment(@PathVariable("orderId") Long orderId, @RequestParam("paymentType") String paymentType) {
        PaymentTypeEnum paymentTypeEnum = PaymentTypeEnum.valueOf(paymentType.toUpperCase());
        paymentUseCase.payment(orderId, paymentTypeEnum);
        return ResponseEntity.noContent().build();
    }
}
