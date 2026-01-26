package com.springai.openai.config;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    public ObservationRegistry observationRegistry() {
        return ObservationRegistry.NOOP;
    }

    @Bean
    public OllamaChatModel llama3ChatModel(OllamaApi ollamaApi, ObservationRegistry observationRegistry) {
        System.out.println("OllamaChatModel - Llama3");
        return OllamaChatModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(OllamaChatOptions.builder().model("llama3.2:1b").temperature(0.7).build())
                .observationRegistry(observationRegistry)
                .build();
    }

    @Bean
    public OllamaChatModel mistralChatModel(OllamaApi ollamaApi, ObservationRegistry observationRegistry) {
        System.out.println("OllamaChatModel - mistral");
        return OllamaChatModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(OllamaChatOptions.builder().model("mistral").temperature(0.7).build())
                .observationRegistry(observationRegistry)
                .build();
    }
}
