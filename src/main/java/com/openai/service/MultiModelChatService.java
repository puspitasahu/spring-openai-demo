package com.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
@Service
public class MultiModelChatService {
    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;

    public MultiModelChatService(@Qualifier("openAiChatClient") ChatClient openAiChatClient,
                                 @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    public String chatWithOpenAI(String message){
        return openAiChatClient
                .prompt(message)
                .call()
                .content();

    }
   public String chatWithOllama(String message){
        return ollamaChatClient
                .prompt(message)
                .call()
                .content();

    }
}
*/
