package com.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAIConfiguration {
    @Bean(name="openAiChatClient")
    public ChatClient openAiChatClient(OpenAiChatModel openAIChatModel) {
        return ChatClient.builder(openAIChatModel).build();
    }

    @Bean(name="ollamaChatClient")
    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel){
        return ChatClient.builder(ollamaChatModel).build();
    }
}
