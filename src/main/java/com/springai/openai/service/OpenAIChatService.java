package com.springai.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class OpenAIChatService {

    private final ChatClient llama3ChatClient;
    private final ChatClient mistralChatClient;

    public OpenAIChatService(OllamaChatModel llama3ChatModel, OllamaChatModel mistralChatModel) {
        this.llama3ChatClient = ChatClient.builder(llama3ChatModel).build();
        this.mistralChatClient = ChatClient.builder(mistralChatModel).build();
    }

    public String chatWithLlama3(String prompt) {
        System.out.println("Chatting with Llama3");
        return llama3ChatClient
                .prompt(prompt)
                .call()
                .content();
    }

    public String chatWithMistral(String prompt) {
        System.out.println("Chatting with Mistral");
        return mistralChatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
