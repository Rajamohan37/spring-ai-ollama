package com.springai.openai.api;

import com.springai.openai.service.MessageRolesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InsurancePolicyApi {

    private final MessageRolesService messageRolesService;

    public InsurancePolicyApi(MessageRolesService messageRolesService) {
        this.messageRolesService = messageRolesService;
    }

    @GetMapping("/insurance/policy/check")
    public String checkPolicy(@RequestParam String message) {
        return messageRolesService.checkPolicy(message);
    }
}
