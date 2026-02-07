package com.springai.openai.api;

import com.springai.openai.service.OpenAIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OpenAiChatApi {

    private final OpenAIChatService openAIChatService;

    public OpenAiChatApi(OpenAIChatService openAIChatService) {
        this.openAIChatService = openAIChatService;
    }

    @GetMapping("/ollama/llama/chat")
    public String chatLlama(String prompt) {
        return openAIChatService.chatWithLlama3(prompt);
    }

    @GetMapping("/ollama/mistral/chat")
    public String chatMistral(String prompt) {
        return openAIChatService.chatWithMistral(prompt);
    }

}
