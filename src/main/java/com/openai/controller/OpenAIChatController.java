package com.openai.controller;

import com.openai.service.MessagesRolesDemoService;
import com.openai.service.OpenAIChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai/api")
public class OpenAIChatController{
    private final OpenAIChatService openAIChatService;
    private final MessagesRolesDemoService messagesRolesDemoService;

    public OpenAIChatController(final OpenAIChatService openAIChatService,MessagesRolesDemoService messagesRolesDemoService){
        this.openAIChatService = openAIChatService;
        this.messagesRolesDemoService=messagesRolesDemoService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message){
        return openAIChatService.chatWithOpenAILLM(message);
    }

    @GetMapping("/check/policy")
    public ChatResponse checkInsurancePolicy(@RequestParam String message){
        return messagesRolesDemoService.checkInsuranceV3Policy(message);
    }

    @GetMapping("/guide")
    public String guideUser(@RequestParam String topic,@RequestParam String level,@RequestParam int points){
        return messagesRolesDemoService.guideMe(topic,level,points);
    }


}

