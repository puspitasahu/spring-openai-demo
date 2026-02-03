package com.openai.controller;

import com.openai.service.OrderSupportAIAssistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSupportAIAssistantController{
    private OrderSupportAIAssistanceService aiAssistanceService;

    public OrderSupportAIAssistantController(final OrderSupportAIAssistanceService aiAssistanceService){
        this.aiAssistanceService = aiAssistanceService;
    }
    @GetMapping("/order-support")
    public String getOrderSupportResponse(@RequestParam String customerName,@RequestParam String orderId,@RequestParam String customerMessage){
        return aiAssistanceService.assistWithOrderSupport(customerName,orderId,customerMessage);
    }

    @GetMapping("/order-ai-support")
    public String talkToOrderAISupport(@RequestParam String customerName,@RequestParam String orderId,@RequestParam String customerMessage){
        return aiAssistanceService.talkToAISupport(customerName,orderId,customerMessage);
    }


}
