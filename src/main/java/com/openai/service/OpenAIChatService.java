package com.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAIChatService{
    private final ChatClient chatClient;

    public OpenAIChatService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    //Message Roles:
    //User : User messages role(questions)
    //System :Rules,instruction
    //Assistant : AI Response
    //Tool : Function calling Input
    public String chatWithOpenAILLM(String message){
    return chatClient.prompt(message).call().content();

    }
}

