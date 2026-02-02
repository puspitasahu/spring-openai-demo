package com.openai.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderSupportAIAssistanceService{
    private final ChatClient chatClient;

    @Value("classpath:prompts/order_system_templates.st")
    private Resource orderSystemPrompt;
    @Value("classpath:prompts/order_user_templates.st")
    private Resource orderUserPrompt;

    public OrderSupportAIAssistanceService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    public String assistWithOrderSupport(String customerName,String orderId,String customerMessage){
        return chatClient.prompt().system(orderSystemPrompt)
                .user(promptUserSpec -> promptUserSpec.text(orderUserPrompt)
                        .param("customerName",customerName)
                        .param("orderId",orderId)
                        .param("customerMessage",customerMessage)
                )

                .call()
                .content();
    }

}
