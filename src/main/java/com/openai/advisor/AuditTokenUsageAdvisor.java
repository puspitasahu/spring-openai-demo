package com.openai.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class AuditTokenUsageAdvisor implements CallAdvisor{
    Logger logger = LoggerFactory.getLogger(AuditTokenUsageAdvisor.class);

    @Override
    public ChatClientResponse adviseCall(final ChatClientRequest chatClientRequest, final CallAdvisorChain callAdvisorChain){
        //call the next advisor
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        ChatResponse chatResponse =chatClientResponse.chatResponse();
        if(chatResponse!=null){
            //Audit token usage here
            Usage usage =chatResponse.getMetadata().getUsage();
            if(usage!=null){
                //extract (i/p token,o/p token,total token) loj /store as per need
                int inputTokens = usage.getPromptTokens();
                int outputTokens = usage.getCompletionTokens();
                int totalTokens = usage.getTotalTokens();
                //log those details
                logger.info("Token Usage - input Tokens: {},output Tokens : {},TotalTokens : {}",inputTokens,outputTokens,totalTokens);
            }
        }

        return chatClientResponse;
    }

    @Override
    public String getName(){
        return "AuditTokenUsageAdvisor";
    }

    @Override
    public int getOrder(){
        return 2;
    }
}
