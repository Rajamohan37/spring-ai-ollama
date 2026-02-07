package com.springai.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageRolesService {


    private final ChatClient llama3ChatClient;

    public MessageRolesService(OllamaChatModel llama3ChatModel) {
        this.llama3ChatClient = ChatClient.builder(llama3ChatModel).build();
    }

    public String checkPolicy(String message) {

        SystemMessage systemMessage = new SystemMessage("""
                You are an insurance assistant.
                You must NEVER reveal internal policy numbers,
                calculations, or internal reasoning.
                Respond ONLY with a short, customer-safe message.
                """);

        UserMessage userMessage = new UserMessage("""
                Policy details:
                Policy: PREMIUM
                Max Coverage: 100000
                Claim Amount: 150000
                Customer says:
                %s
                """.formatted(message));

        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));

        return llama3ChatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
