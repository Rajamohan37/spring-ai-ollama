package com.springai.openai.api;

import com.springai.openai.service.OrderSupportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderSupportApi {

    private final OrderSupportService orderSupportService;

    public OrderSupportApi(OrderSupportService orderSupportService) {
        this.orderSupportService = orderSupportService;
    }

    @GetMapping("/order/cust-support")
    public String chatLlama(String name, String orderId, String message) {
        return orderSupportService.assistWithOrder(name, orderId, message);
    }
}
