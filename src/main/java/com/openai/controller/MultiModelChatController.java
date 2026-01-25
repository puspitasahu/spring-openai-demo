package com.openai.controller;

import com.openai.service.MultiModelChatService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multi-model/api")
class MultiModelChatController {
    private final MultiModelChatService multiModelChatService;

    public MultiModelChatController(MultiModelChatService multiModelChatService) {
        this.multiModelChatService = multiModelChatService;
    }
    @GetMapping("/chat/openai")
    public String chatWithOpenAI(@RequestParam String message){
        return multiModelChatService.chatWithOpenAI(message);

    }

    @GetMapping("/chat/ollama")
    public String chatWithOllama(@RequestParam String message){
        return multiModelChatService.chatWithOllama(message);

    }
}
