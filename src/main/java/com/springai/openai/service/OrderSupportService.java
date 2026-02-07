package com.springai.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderSupportService {

    private final ChatClient chatClient;

    @Value("classpath:prompts/order_support_sys_template.st")
    private Resource orderSupportSystemPrompt;

    @Value("classpath:prompts/order_support_user_template.st")
    private Resource orderSupportUserPrompt;

    public OrderSupportService(OllamaChatModel chatClient) {
        this.chatClient = ChatClient.builder(chatClient).build();
    }

    public String assistWithOrder(String name, String orderId, String message) {

        return chatClient
                .prompt()
                .system(orderSupportSystemPrompt)
                .user((spec) -> spec.text(orderSupportUserPrompt)
                        .param("name", name)
                        .param("orderId", orderId)
                        .param("customerMessage", message))
                .call().content();

    }
}
