package com.springai.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class OrderSupportService {

    private final ChatClient chatClient;

    public OrderSupportService(OllamaChatModel chatClient) {
        this.chatClient = ChatClient.builder(chatClient).build();
    }

    public String assistWithOrder(String name, String orderId, String message) {

        return chatClient
                .prompt()
                .system("""
                        You are a professional e-commerce customer support assistant.
                        Your goal is to write a clear, empathetic and solution oriented email responses.
                        Never blame the customer or the company.
                        Keep the response concise and friendly.
                        Use the customer provided information and order details to generate accurate responses.
                        
                        """)
                .user((spec) -> spec.text("""
                        A customer names {name} contracted support regarding order id {orderId}.
                        
                        Customer Message:
                        "{customerMessage}"
                        
                        Your Task:
                        - Understand the customers issue clearly.
                        - Apologize if there is any inconvenience.
                        - Provide a helpful next step or resolution.
                        - Maintain a professional and polite tone.
                        - Do not include subject line or signature.
                        """)
                        .param("name", name)
                        .param("orderId", orderId)
                        .param("customerMessage", message))
                .call().content();

    }
}
