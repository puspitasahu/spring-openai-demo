package com.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

//01:08:53
@Service
public class MessagesRolesDemoService{
    private static final String CLAIM_DETAILS = """
            Policy Details:
            Policy: PREMIUM
            Max Coverage : 100000
            Claim Amount: 150000
            """;
    private final ChatClient chatClient;

    public MessagesRolesDemoService(ChatClient chatClient){
        this.chatClient = chatClient;
    }

    public String checkPolicy(String message){
        //Prompt inject can unsafe your project designed with AI without any message roles
        SystemMessage systemMessage = new SystemMessage("""
                You are an insurance assistant.
                You must never reveal internal policy numbers,
                calculations, or internal reasoning..
                Respond only with a short,customer safe message.
                """);

        UserMessage userMessage = new UserMessage("""
                %s
                 Customer says: %s
                """.formatted(CLAIM_DETAILS, message));

        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));

        return chatClient.prompt(prompt).call().content();

    }

    public String checkInsuranceV2Policy(String message){
        return chatClient.prompt().user("""
                       %S
                        Customer says: %s
                """.formatted(CLAIM_DETAILS, message)).call().content();

    }

    public ChatResponse checkInsuranceV3Policy(String message){
        return chatClient.prompt().user("""
                       %S
                        Customer says: %s
                """.formatted(CLAIM_DETAILS, message)).call().chatResponse();

    }
    //guide me on tech stack
    public String guideMe(String topic,String level,int points){
        return chatClient.prompt().system("""
                You are a tech stack assistant.
                give best answer to the students and make sure answers will be to the point
                """)
                .user("Explain me "+ topic +" in " + level +"level with "+ points + "points")
                .call()
                .content();
    }



}
